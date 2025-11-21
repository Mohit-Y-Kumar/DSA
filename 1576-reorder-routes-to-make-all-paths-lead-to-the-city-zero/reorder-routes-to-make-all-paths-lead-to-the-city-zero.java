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
        return bfs(adj, n);
    }

    private int  bfs(List<List<Edge>> adj, int n){
        int count=0;
        boolean vis[] =new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] =true;
        while(!q.isEmpty()){
            int curr =q.remove();
            for (Edge e : adj.get(curr)) {
                if (!vis[e.to]) {
                    vis[e.to] = true;

                    // cost = 1 means original direction needs reversing
                    count += e.cost;

                    q.add(e.to);
                }
            }
            
        }
         return count;

    }
}





    