class Solution {
    public int maxSubArray(int[] nums) {
        int n =nums.length;
        int maxsum =Integer.MIN_VALUE;
        int currsum =0;
 
     if (n ==1){
        return nums[0];
     }
       
        for(int i =0;i<n;i++){
             currsum +=nums[i];
             maxsum =Math.max(currsum,maxsum);
            if(currsum<0){
                currsum =0;
            }
           

        }
        return maxsum;
        
    }
}