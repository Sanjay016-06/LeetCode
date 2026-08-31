class Solution {
    public class Pair{
        int vtx;
        int cost;
        public Pair(int vtx, int cost){
            this.vtx = vtx;
            this.cost = cost;
        }
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(i,new HashMap<>());
        }
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            map.get(a).put(b,c);
            map.get(b).put(a,c);
        }

        int[] start = dijkstra(map,0);
        int[] end = dijkstra(map,n-1);

        boolean[] ans = new boolean[edges.length];
        int i = 0;
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            if(start[a] + end[b]+c == start[n-1]){
                ans[i] = true;
            }
            if(start[b] + c + end[a] == start[n-1]){
                ans[i] = true;
            }
            i++;
        }
        return ans;
    }
    public int[] dijkstra(HashMap<Integer,HashMap<Integer,Integer>> map, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Pair(src,0));
        int[] dis = new int[map.size()];
        Arrays.fill(dis,(int)(1e9));
        dis[src] = 0;
        while(!pq.isEmpty()){
            Pair rv = pq.poll();
            int vtx = rv.vtx;
            int cost = rv.cost;
            for(int nbrs : map.get(vtx).keySet()){
                int c = map.get(vtx).get(nbrs) + cost;
                if(c < dis[nbrs]){
                    dis[nbrs] = c;
                    pq.add(new Pair(nbrs,c));
                }
            }
        }
        return dis;
    }
}