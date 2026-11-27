
class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] p = new int[n + 1];

        int first = -1, second = -1;

        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];

            if (p[v] == 0)
                p[v] = u;
            else {
                first = p[v];
                second = i;
            }
        }

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            if (i == second) continue;

            int u = find(edges[i][0]);
            int v = find(edges[i][1]);

            if (u == v) {
                if (second == -1)
                    return edges[i];

                return new int[]{first, edges[second][1]};
            }

            parent[u] = v;
        }

        return edges[second];
    }
}
