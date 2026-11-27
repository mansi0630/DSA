
class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 1; i < parent.length; i++)
            parent[i] = i;

        for (int[] e : edges) {
            int u = find(e[0]);
            int v = find(e[1]);

            if (u == v)
                return e;

            parent[u] = v;
        }

        return new int[0];
    }
}
