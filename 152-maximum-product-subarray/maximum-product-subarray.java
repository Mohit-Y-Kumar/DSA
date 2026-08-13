class Solution {
    public int maxProduct(int[] nums) {
        int leftprod =1,rightprod =1;
        int res =nums[0];
        int n =nums.length;
        
        for(int i =0;i<nums.length;i++){
            if(leftprod ==0) {
             leftprod =1;
            }
            if(rightprod ==0) {
             rightprod =1;
            }
            leftprod *=nums[i];
            rightprod *=nums[n-1-i];
            
             res =Math.max(res,Math.max(leftprod,rightprod));
        }
       return res;
        
    }
}