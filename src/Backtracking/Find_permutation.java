package Backtracking;

public class Find_permutation {

    public static void find_Permutation(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        //Recursion
        for (int i = 0; i <str.length() ; i++) {
            char curr =str.charAt(i);

            // "abcde" =>"ab" + "de" ="abde"

            String Newstr =str.substring(0,i) +str.substring(i+1);
            find_Permutation(Newstr,ans+curr);
        }



    }

    public static void main(String[] args) {
        String str ="abc";
        find_Permutation(str,"");
    }
}
