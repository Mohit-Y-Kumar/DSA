import java.util.*;

class Solution {

    // The DFS should return a double value, not use output parameters
    private double dfs(Map<String, Map<String, Double>> graph, String src, String dest, Set<String> visited, double currentProduct) {
        
        // Base Case 1: If source or destination is not in the graph
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            return -1.0; 
        }

        // Base Case 2: If we reached the destination
        if (src.equals(dest)) {
            return currentProduct;
        }

        visited.add(src);

        // Iterate through neighbors
        Map<String, Double> neighbors = graph.get(src);
        for (Map.Entry<String, Double> neighborEntry : neighbors.entrySet()) {
            String neighborNode = neighborEntry.getKey();
            double weight = neighborEntry.getValue();

            if (!visited.contains(neighborNode)) {
                // Recursive call: pass the updated product
                double result = dfs(graph, neighborNode, dest, visited, currentProduct * weight);
                
                // If a valid path was found in the recursive call
                if (result != -1.0) {
                    return result;
                }
            }
        }

        visited.remove(src); // Backtrack
        return -1.0; // No path found from this node
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // --- Build the Graph (Adjacency List) ---
        Map<String, Map<String, Double>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            // Add a>b and b>a edges
            adj.putIfAbsent(u, new HashMap<>());
            adj.putIfAbsent(v, new HashMap<>());
            
            adj.get(u).put(v, val);
            adj.get(v).put(u, 1.0 / val);
        }

        // --- Process Queries ---
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String startNode = queries.get(i).get(0);
            String endNode = queries.get(i).get(1);
            
            // Start the DFS traversal for each query
            // The initial product must be 1.0
            results[i] = dfs(adj, startNode, endNode, new HashSet<>(), 1.0);
        }
        
        return results;
    }
}
