package HashMap;

import java.util.HashMap;
import java.util.Set;

public class _4_Majority_el {
    public static void main(String[] args) {
        int arr[] ={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);

            // this code same as upper line code
//            if(hm.containsKey(arr[i])){
//                hm.put(arr[i],hm.get(arr[i])+1);
//            }
//            else {
//                hm.put(arr[i],1);
//            }

        }

        for(Integer key : hm.keySet()){
            if(hm.get(key) > arr.length/3){
                System.out.println(key);
            }
        }


    }
}
