class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] t : times)
            adj[t[0]].add(new int[]{t[1], t[2]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u]) continue;

            for (int[] e : adj[u]) {
                int v = e[0], w = e[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}