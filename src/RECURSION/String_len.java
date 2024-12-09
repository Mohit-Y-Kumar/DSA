package RECURSION;

public class String_len {
    public static void main(String[] args) {
        String str ="google";

        System.out.println(Find_len(str));
    }
    public static int Find_len(String str ){
        if(str.length()==0){
            return 0;
        }
       return Find_len(str.substring(1))+1;
    }
}
