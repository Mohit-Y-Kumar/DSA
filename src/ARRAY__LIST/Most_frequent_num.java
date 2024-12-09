package ARRAY__LIST;

import java.util.ArrayList;

public class Most_frequent_num {
    public static int countFreq(ArrayList<Integer>list,int target){
        int [] result =new int[1000];
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == target) {
                result[list.get(i + 1) - 1]++;
            }
        }
        int max =Integer.MIN_VALUE;
        int ans =0;
        for (int i = 0; i <1000 ; i++) {
            if (result[i] >max){
                max =result[i];
                ans=i+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer>list =new ArrayList<>();
        list.add(6);
        list.add(9);
        list.add(8);
        list.add(0);
        list.add(7);
        list.add(9);




        int target =9; //value
        System.out.println(countFreq(list,target));

    }
}
