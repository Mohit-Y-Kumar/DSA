package HashMap;

import java.util.LinkedHashMap;
import java.util.TreeMap;


public class _3_Lhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer>lhm =new LinkedHashMap<>();
        lhm.put("India",340);
        lhm.put("US",40);
        lhm.put("China",340);

        System.out.println(lhm);


        TreeMap<String,Integer> tm =new TreeMap<>();
        tm.put("India",340);
        tm.put("US",40);
        tm.put("China",340);

        System.out.println(tm);
    }
}
