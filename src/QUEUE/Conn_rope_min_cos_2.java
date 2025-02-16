package QUEUE;

import java.util.PriorityQueue;

public class Conn_rope_min_cos_2 {
    static void minCost(int len[]){
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
        for(int i =0;i<len.length;i++){
            pq.add(len[i]);
        }
        int res =0;
        while (pq.size()>1){
            int first =pq.poll();
            int second =pq.poll();
            res+= first+second;
            pq.add(first+second);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int len[] ={1,2,3 };
        minCost(len);
    }
}
