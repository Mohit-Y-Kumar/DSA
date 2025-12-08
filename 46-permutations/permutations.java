class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        backtrack(res,0,nums);
        return res;

    
        
    }
    private void backtrack(List<List<Integer>> res,int idx,int[] nums){
       if(idx == nums.length){
        List<Integer> current =new ArrayList<>();
        for(int num :nums){
            current.add(num);
        }
        res.add(current);
        return;

       }
       for(int i =idx;i<nums.length;i++){
        swap(nums,idx,i);
        backtrack(res,idx+1,nums);
        swap(nums,idx,i); //back track


       }
       
       
    }

    private void swap (int[] nums,int i ,int j){
        int temp =nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }

}