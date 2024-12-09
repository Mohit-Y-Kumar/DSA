package DIVIDE_CONQUER;

import com.sun.source.tree.BreakTree;

public class _2_major_el_brute {
    public static int majorityElements(int nums[]){
        int majorityCount =nums.length/2;
        int count =0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                count++;
            }
            if(count>majorityCount){
                return nums[i];
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int nums[] ={2,2,1,1,1,2,2};
        System.out.println(majorityElements(nums));

    }
}
