class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n =nums.length;
       Arrays.sort(nums,(a,b)->{
        if(a.length() != b.length()){
            return a.length() - b.length();
        }
        return a.compareTo(b);
       });
       
       return nums[n-k];
    }
}