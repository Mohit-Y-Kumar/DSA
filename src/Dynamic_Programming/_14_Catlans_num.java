package Dynamic_Programming;

public class _14_Catlans_num {
    //recursion
    public static int CatlanRec(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans =0;
        for (int i = 0; i <n ; i++) {
            ans+= CatlanRec(i)* CatlanRec(n-i-1);

        }
        return ans;
    }

    public static int Catlan(int n ,int dp[]){

        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans =0;
        for (int i = 0; i <n ; i++) {
            ans+= Catlan(i,dp)*Catlan(n-i-1,dp);

        }
        return  dp[n] =ans;
    }
    public static int Catlan_Tab(int n ){
        int dp[] =new int[n+1];
        dp[0] =1;
        dp[1] =1;

        for (int i = 2; i <n ; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] +=dp[j] * dp[i-j-1];  //Ci = Cj * Ci -j-1

            }
        }

        return  dp[n];
    }


    public static void main(String[] args) {
//        System.out.println(CatlanRec(4));
        int n =4;
//        int dp[] =new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println(Catlan(n,dp));

        System.out.println(CatlanRec(n));
    }
}
