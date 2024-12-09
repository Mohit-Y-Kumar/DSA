package RECURSION;



public class num_T0_Str {
    static String digits[] ={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void main(String[] args) {
        ConvertStr(1345);
        System.out.println();

    }
    public static void ConvertStr(int number){
        if(number ==0){
            return;
        }

        int lastDigit =number%10;
        ConvertStr(number/10);
        System.out.print(digits[lastDigit]+" ");
    }
}
