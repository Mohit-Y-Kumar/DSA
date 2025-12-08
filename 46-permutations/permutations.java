class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
        return res;

    
        
    }
    private void backtrack(List<List<Integer>> res,ArrayList<Integer> temp,int[] nums){
        if(temp.size() ==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int number : nums){

            if(temp.contains(number)){
                continue;
            }
        
            temp.add(number);

            backtrack(res,temp,nums);

            temp.remove(temp.size()-1);
        }
    }

}