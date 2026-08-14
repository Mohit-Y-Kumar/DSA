class Solution {
    public void nextPermutation(int[] nums) {
        int n =nums.length;
        int markidx =-1;
        // markk
        for(int i =n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                markidx =i-1; 
                break;
            }
        }

      //if no markidx find then rev entire arr
      if(markidx ==-1){
        reverse(nums,0,n-1);
        return;
      }

        //swap with rightmsot element;
        for (int j = n - 1; j > markidx; j--) {
            if (nums[j] > nums[markidx]) {
                int temp = nums[markidx];
                nums[markidx] = nums[j];
                nums[j] = temp;
                break; // Stop after the first swap
            }
        }
    
    //rev arr from markidx+1 to n;
    reverse(nums,markidx+1,n-1);
        
}  
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            r--;
            l++;
        }
    }
    
}
    
