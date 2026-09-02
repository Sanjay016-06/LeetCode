class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<routes.length; i++){
            for(int j = 0; j<routes[i].length; j++){
                map.putIfAbsent(routes[i][j],new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> st = new HashSet<>();
        if(!map.containsKey(source)){
            return -1;
        }
        for(int src : map.get(source)){
            q.add(src);
            st.add(src);
        }

        int bus = 0;
        while(!q.isEmpty()){
            int n = q.size();
            bus++;
            for(int i = 0; i<n; i++){
                int node = q.poll();
                for(int nbrs : routes[node]){
                    if(nbrs == target){
                        return bus;
                    }
                    for(int rv : map.get(nbrs)){
                        if(!st.contains(rv)){
                            st.add(rv);
                            q.add(rv);
                        }
                    }
                }
            }
        }
        return -1;
    }
}