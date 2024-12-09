package RECURSION;

public class Count_Substring {
    public static void main(String[] args) {
        String str ="abcab";
        int n  =str.length();
        System.out.print(countSubtrings(str,0,n-1,n));
    }
    public static int countSubtrings(String str,int i,int j,int n){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }

        int res =countSubtrings(str,i+1,j,n-1) +
                countSubtrings(str,i,j-1,n-1) -
                countSubtrings(str,i+1,j-1,n-2);

        if (str.charAt(i) ==str.charAt(j)){
            res++;
        }
        return res;
    }
}
