package Greedy_Algorithms;

import java.security.Key;

public class _8b_KthOdd_inRange {
    public static int kthOdd(int[] range,int K){
        if(K <=0) {
            return 0;
        }

        int L =range[0];
        int R =range[1];

        if((R&1) > 0){
            int Count =(int) Math.ceil((R-L+1) /2);
            if(K>Count){
                return 0;
            }
            else
                return (R-2*K+2);
        }else {
            int Count =(R-L +1)/2;
            if(K>Count)
                return 0;
            else
                return (R-2*K+1);
        }
    }

    public static void main(String[] args) {
        int[] p ={-3,3};
        int K =1;
        System.out.println(kthOdd(p,K));
    }
}
