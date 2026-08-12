class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n= nums.length;
       Set<Integer> s =new HashSet<>(n);
        
        for(int i =0;i<n;i++){
            if(s.contains(nums[i])){
                return true;
            }
            if(!s.contains(nums[i])){
                s.add(nums[i]);
               
            }
            
        }
        return false;
        
    }
}