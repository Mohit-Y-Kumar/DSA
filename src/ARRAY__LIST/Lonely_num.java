package ARRAY__LIST;

import java.util.ArrayList;
import java.util.Collections;

public class Lonely_num {


    public static ArrayList<Integer> lonelyNum(ArrayList<Integer> list){
        Collections.sort(list);
        ArrayList<Integer> lonelyList =new ArrayList<>();

        for (int i = 1; i <list.size()-1 ; i++) {

            //check mid values previous or next value
            if (list.get(i - 1) + 1 < list.get(i) && list.get(i + 1) > list.get(i) + 1) {
                lonelyList.add(list.get(i));
            }
        }
            //list contain one elmt
            if(list.size()==1){
                lonelyList.add(list.get(0));

            }
            //list contain more than 1 elmt
            if(list.size()>1){
                //check first position
                if(list.get(0)+1<list.get(1)){
                    lonelyList.add(list.get(0));
                }
                //last elmt
                if(list.get(list.size()-2)+1 <  list.get(list.size()-1)){
                    lonelyList.add(list.get(list.size()-1));
                }
            }


        return lonelyList;
    }

    public static void main(String[] args) {
        ArrayList<Integer>list =new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.println(lonelyNum(list));
    }
}
