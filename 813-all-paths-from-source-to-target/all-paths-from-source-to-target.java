class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
         // Start DFS from node 0
        path.add(0);
        dfs(graph, 0, path, result);
        return result;

        
    }
    private void dfs(int[][] graph,int node,List<Integer> path, List<List<Integer>> result ){
        if(node ==graph.length-1){
            result.add(new ArrayList<> (path));
            return;
        }
        //
        for(int neighbour : graph[node]){
            path.add(neighbour);// choose
            dfs(graph,neighbour,path,result); //explore nodes
            path.remove(path.size() -1);//backtrack
        }
    }
}