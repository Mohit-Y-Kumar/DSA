package Dynamic_Programming;

import java.util.Arrays;

public class _2_Climbing_Stair {
    public static int countWays(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n] !=-1){
            return ways[n];
        }
        ways[n]= countWays(n-1,ways)+countWays(n-2,ways);
        return ways[n];
    }

    public static int countWaysTab(int n){
        int dp[] =new int[n+1];
        dp[0] =1;

        //tabulation
        for (int i = 1; i <=n ; i++) {
            if(i==1){
                dp[i] =dp[i-1]+0;
            }else {
                dp[i] =dp[i-1]+dp[i-2];

            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n =999;  //n =3 ->3 & n=4 ->5 =>8
        int ways[] =new int[n+1]; // 0,0,0,0
        Arrays.fill(ways,-1);  // -1,-1,-1

        System.out.println("rec_Memorization");
        System.out.println(countWays(n,ways));
        System.out.println("Tabular => "+countWaysTab(n));
    }
}
