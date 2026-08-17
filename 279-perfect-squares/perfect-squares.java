class Solution {
    int arr[];
    public int solve(int n ){
       
        if(arr[n] !=-1){
            return arr[n];
        }
         if(n==0) return 0;
       int min =Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int res =1+solve(n-i*i);
           min =Math.min(min,res);
           arr[n] =min;
        }
        return arr[n];
    }
    public int numSquares(int n) {
         arr =new int[n+1];
        Arrays.fill(arr,-1);
        
        return solve(n);
    }
}