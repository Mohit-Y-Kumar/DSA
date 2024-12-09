package RECURSION;

public class Fibb {
    public static void main(String[] args) {
        System.out.println(Fibo(6));
    }

    public static int Fibo(int n){
        if(n==0){
            return 0;

        } else if (n==1) {
            return 1;
        }
        int fib =Fibo(n-1)+Fibo(n-2);
        return fib;
    }
}
