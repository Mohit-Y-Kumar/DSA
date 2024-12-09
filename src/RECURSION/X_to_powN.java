package RECURSION;

public class X_to_powN {
    public static void main(String[] args) {
        System.out.println(X_powN(2,9));
    }
//    public static int X_powN(int x ,int n){
//        if(n==0){
//            return 1;
//        }
//      int  res =x*X_powN(x,n-1);
//        return res;
//    }

    //OPTIMAL SOLUTION

    public static  int X_powN(int x ,int n){
        if(n==0){
            return 1;
        }
        int halfpower =X_powN(x,n/2);
        int halfPowerSq =halfpower*halfpower;

        //n is odd
        if(n%2 != 0){
            halfPowerSq =x*halfPowerSq;
        }
        return halfPowerSq;
    }
}
