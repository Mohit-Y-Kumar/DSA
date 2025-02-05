package HashMap;

import java.util.HashMap;
import java.util.Set;

public class _1_Hashmap_iter {
    public static void main(String[] args) {
        HashMap<String,Integer> hm =new HashMap<>();

        hm.put("India",10);
        hm.put("Afgan",42);
        hm.put("china",23);

        System.out.println(hm);

        //Iterate
        Set<String> keys =hm.keySet();

        for (String k: keys){
            System.out.println("keys = "+k+",values= "+hm.get(k ));
        }

    }
}
