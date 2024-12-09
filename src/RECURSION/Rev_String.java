package RECURSION;

public class Rev_String {
    public static void main(String[] args) {
        String str ="java";
        Reverse(str,str.length()-1);
    }

    public static void Reverse(String str,int idx){
        if(idx ==0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx) +" ");
        Reverse(str,idx-1);
    }

}
