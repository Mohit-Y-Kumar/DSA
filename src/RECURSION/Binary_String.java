package RECURSION;

public class Binary_String {
    public static void main(String[] args) {
Binary_str(3,0,"");
    }

    public static void Binary_str(int n,int lastPlace,String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kam
        Binary_str(n-1,0,str+"0");
        if(lastPlace ==0){
            Binary_str(n-1,1,str+"1");
        }
    }
}
