class Solution {

    // Edge class to store: neighbor and cost (1 = needs reverse, 0 = correct)
    class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int minReorder(int n, int[][] connections) {

        // Create adjacency list
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph using cost logic
        for (int[] c : connections) {
            int a = c[0], b = c[1];

            // a -> b is the original direction => wrong direction => cost = 1
            adj.get(a).add(new Edge(b, 1));

            // b -> a is a reverse direction => good direction => cost = 0
            adj.get(b).add(new Edge(a, 0));
        }

        // Start DFS from node 0
        return dfs(adj, 0, -1);
    }

    // DFS to count reversals
    private int dfs(List<List<Edge>> adj, int node, int parent) {
        int changes = 0;

        for (Edge e : adj.get(node)) {

            if (e.to == parent) continue;  // avoid going back to parent

            // If cost = 1 → edge is wrong direction → must reverse
            changes += e.cost;

            // Recursive DFS
            changes += dfs(adj, e.to, node);
        }

        return changes;
    }
}
