package HashMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class _6_HashSet {
    public static void main(String[] args) {
        HashSet<String> cities =new HashSet<>();
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Agra");
        cities.add("Jaipur");

        System.out.println(cities);

        //Iterate
//        Iterator it =cities.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        for(String city: cities){
//            System.out.println(city);
//        }

        LinkedHashSet<String> lhs =new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Noida");
        lhs.add("Agra");
        lhs.add("Jaipur");

        System.out.println(lhs);
        TreeSet<String>ts =new TreeSet<>();
        ts.add("Delhi");
        ts.add("Noida");
        ts.add("Agra");
        ts.add("Jaipur");
        System.out.println(ts);

        int arr[] ={3,4,2,3,1,6,7,5};
        HashSet<Integer> has =new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            has.add(arr[i]);

        }
        System.out.println(has.size());


        int arr1[] ={7,3,9};
        int arr2[] ={6,3,9,2,9,4};
        HashSet<Integer>s =new HashSet<>();


        //union
        for (int i = 0; i <arr1.length ; i++) {
        s.add(arr1[i]);

        }
        for (int i = 0; i < arr2.length; i++) {
            s.add(arr2[i]);

        }
        System.out.println("Union = "+s.size());

        //InterSection
        s.clear();
        for (int i = 0; i <arr1.length ; i++) {
            s.add(arr1[i]);
        }
        int count =0;
        for (int i = 0; i < arr2.length; i++) {

            if(s.contains(arr2[i])) {
                count++;
                s.remove(arr2[i]);
            }
        }
        System.out.println("InterSection ="+count);

    }
}
