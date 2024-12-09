package ARRAY__LIST;

import java.util.ArrayList;
import java.util.Collections;

public class Swap {
    public static void swap(ArrayList<Integer> list,int indx1,int indx2){
        int temp =list.get(indx1);
        list.set(indx1,list.get(indx2));
        list.set(indx2,temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(4);  //O(1)
        list.add(2);
        list.add(8);
        list.add(0);
        list.add(6);

        System.out.println(list);
        int indx =2;  int indx2 =4;
        swap(list,indx,indx2);
        System.out.println(list);

        System.out.println("sort ascending");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("sort decending");
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);

    }
}
