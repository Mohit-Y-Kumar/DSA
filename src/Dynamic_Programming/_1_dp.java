package Dynamic_Programming;

public class _1_dp {
    public static int fibbo(int n,int f[]){
        if(n==1 || n==0){
            return n;
        }
        if(f[n] !=0){
            return f[n];
        }

        f[n]= fibbo(n-1,f)+fibbo(n-2,f);
        return f[n];
    }

    public static int fibTabulation(int n ){
        int dp[] =new int[n+1];
        dp[0] =0;
        dp[1] =1;
        for (int i = 2; i <=n ; i++) {
            dp[i] =dp[i-1]+dp[i-2];

        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int  f[] =new int [n+1];
        System.out.println(fibbo(n,f));
        System.out.println("Tabulation");
        System.out.println(fibTabulation(n));
    }
}
