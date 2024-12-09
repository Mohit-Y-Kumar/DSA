package RECURSION;

public class Recursion_basic {
    public static void main(String[] args) {
PrintDec(10);
printInc(14);

    }

    public static void PrintDec(int n){
        if(n==1){
            System.out.println(n);
       return;
        }
        System.out.print (n+" ");
        PrintDec(n-1);
    }
    public  static  void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");

    }

}
