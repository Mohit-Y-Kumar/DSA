class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i;
        List<Integer> s=new ArrayList<>();
        Arrays.sort(nums);
        for(i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
            s.add(nums[i]);
        }
        return s;
    }
}