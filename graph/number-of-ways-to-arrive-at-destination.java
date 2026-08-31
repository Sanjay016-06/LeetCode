class Solution {

    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
            );

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long currDist = curr[1];

            if(currDist > dist[node]) {
                continue;
            }

            for(int[] nei : graph.get(node)) {
                int next = nei[0];
                int weight = nei[1];
                long newDist = currDist + weight;

                if(newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];

                    pq.offer(new long[]{next, newDist});
                }
                else if(newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}