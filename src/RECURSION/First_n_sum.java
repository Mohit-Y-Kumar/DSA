package RECURSION;

public class First_n_sum {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
    public static int sum(int n){
        if(n==1){
            return 1;

        }
        int s =n+sum(n-1);
        return s;
    }
}
