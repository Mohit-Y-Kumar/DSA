class Solution {
    static class Node {
    int i, j, t;
    Node(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }
}

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int ans =0;

        Queue<Node> q =new LinkedList<>();
        boolean [][]vis = new boolean[n][m];
 //push all sources in q
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Node(i,j,0));
                }

            }
        }

        //bfs
        while(!q.isEmpty()){
            Node curr =q.poll();
            int i  =curr.i;
            int j =curr.j;
            int t =curr.t;
            ans =Math.max(ans,t);

            if(i-1 >=0 && !vis[i-1][j] && grid[i-1][j] ==1){ //top
              q.add(new Node(i-1,j,t+1));
              vis[i-1][j]=true;
            }
            
            if(i+1 <n && !vis[i+1][j] && grid[i+1][j] ==1){ //bottom
              q.add(new Node(i+1,j,t+1));
              vis[i+1][j]=true;

            }

           
            if(j+1 <m && !vis[i][j+1] && grid[i][j+1] ==1){ //right
              q.add(new Node(i,j+1,t+1));
              vis[i][j+1]=true;

            }

            
            if(j-1 >=0 && !vis[i][j-1] && grid[i][j-1] ==1){ //left
              q.add(new Node(i,j-1,t+1));
              vis[i][j-1]=true;

            }

        }

                //check fresh orange
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1  && !vis[i][j]){
                    return -1;
                }

            }
        }
        return ans;
    }
}