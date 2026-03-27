class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        //Time Complexity - O(m*n)
        //Space Complexity - O(1)

        int m=mat.length;
        int n=mat[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ind=(j+k)%n;
                if(mat[i][j]!=mat[i][ind])
                {
                    return false;
                }
            }
        }
        return true;
    }
}