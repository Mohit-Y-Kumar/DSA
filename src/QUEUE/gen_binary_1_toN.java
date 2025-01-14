package QUEUE;

import java.util.LinkedList;
import java.util.Queue;

public class gen_binary_1_toN {

    static void generateBinary(int N){
        Queue<String> q =new LinkedList<String>();
        q.add("1");
        while (N-->0){
            String s1 =q.peek();
            q.remove();
            System.out.println(s1);
            String s2 =s1;
            q.add(s1 +"0");
            q.add(s2 +"1");
        }
    }

    public static void main(String[] args) {
        generateBinary(5);
    }
}
