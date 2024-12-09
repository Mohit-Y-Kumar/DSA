package ARRAY__LIST;

import java.util.ArrayList;

public class Array_list {
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(4);  //O(1)
        list.add(2);
        list.add(8);
        list.add(0);
        list.add(6);
        list.add(4,67); // o(n)

        System.out.println(list);
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.print(list.get(i)+"  ");
//
//        }
//        System.out.println();
//        ///REVERSE PRINT
//        for (int i =list.size()-1;i>=0;i--) {
//            System.out.print(list.get(i)+"  ");
//
//        }
        int max =Integer.MIN_VALUE;

        for (int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
            }
        }
        System.out.println(max);


//
//        //Get Operation -O(1)
//        int e =list.get(2);  //return value at indx
//        System.out.println(e);
//
//        //delete
//        list.remove(1);  //remove indx value
//        System.out.println(list);
//
//        //set O(1)
//        list.set(3,55); //at 3 indx place 55
//        System.out.println(list);
//
//        //contains
//
//
//        System.out.println( list.contains(4));
    }


}
