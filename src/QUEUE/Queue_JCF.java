package QUEUE;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();  //Array Deque or Linkedlist
        q.add(1);
        q.add(13);
        q.add(12);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
