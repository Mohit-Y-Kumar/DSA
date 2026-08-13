class Solution {
//     int solve(int [] nums,int i ,int n,int[] arr){
//         int n =arr.length;
        
// }

    //     if(i>=n) return 0;
    //     if(arr[i]!= -1) return arr[i];
    //     int steal =nums[i]+solve(nums,i+2,n,arr);
    //     int skip  = solve(nums,i+1,n,arr);
    //    return  arr[i] = Math.max(steal,skip);
    // }
    public int rob(int[] nums) {
        int n =nums.length;
        
        int []dp = new int[n+1];
        dp[0] =0;
        dp[1] =nums[0];

        for(int i =2;i<=n;i++){
            int steal =nums[i-1]+dp[i-2];
            int skip = dp[i-1];
            dp[i] =Math.max(steal,skip);
        }
        return dp[n];
    }
}
    //     int[] arr = new int[101];
    //     Arrays.fill(arr,-1);
    //     return solve(nums,0,n,arr);
    // }
        
// }