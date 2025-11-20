class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V =rooms.size();
        int src =0;
        boolean vis[] =new boolean[V];
        dfs(rooms,src,vis);

        for(boolean x: vis){
            if(x ==false){
                return false;
            }
        }
        return true;
        
    }
    private void dfs(List<List<Integer>> rooms,int node,boolean vis[]){
        vis[node] =true;
        for(int next:rooms.get(node)){
              if(!vis[next]){
                dfs(rooms,next,vis);
              }
        }

    }
}