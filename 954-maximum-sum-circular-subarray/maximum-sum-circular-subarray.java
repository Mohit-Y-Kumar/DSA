class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmaxsum =nums[0];
        int maxsum =nums[0];
        int currminsum =nums[0];
        int minsum =nums[0];
        int totalsum =nums[0];

        for(int i =1;i<nums.length;i++){
            currmaxsum =Math.max(currmaxsum + nums[i],nums[i]);
            maxsum =Math.max(maxsum,currmaxsum);

             currminsum =Math.min(currminsum + nums[i],nums[i]);
             minsum =Math.min(minsum,currminsum);

            totalsum +=nums[i];

        }
        int circularsum =totalsum -minsum;
        if(maxsum<0){
            return maxsum;
        }
        return Math.max(maxsum,circularsum);

    }
}