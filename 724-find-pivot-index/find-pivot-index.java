class Solution {
    public int pivotIndex(int[] nums) {
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
           
         
        }
        int totalsum =0;
        for(int i =0;i<nums.length;i++){
            int ls =totalsum;
            int rs =sum -totalsum -nums[i];
            if(ls ==rs){
                return i;
            }
            totalsum +=nums[i];
        }
        

    
return -1;
        
    }
}