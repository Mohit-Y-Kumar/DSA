package STACK;

import java.util.Stack;

public class Simplify_Path {
    public static void main(String[] args) {
        String str =new String("/a/./b/../../c/");
        String res =IsSimplifyPath(str);
        System.out.println(res);
    }

    public static String IsSimplifyPath(String S){
        Stack<String> str =new Stack<String>();
        String res ="";
        res+="/";
        int len_S  =S.length();
        for (int i = 0; i <len_S ; i++) {
            String dir = "";
            while (i < len_S && S.charAt(i) == '/')
                i++;
            while (i < len_S && S.charAt(i) != '/') {
                dir += S.charAt(i);
                i++;
            }
            if (dir.equals("..") == true) {
                if (!str.empty()) {
                    str.pop();
                }
            }else if (dir.equals(".") == true) {
                    continue;
                } else if (dir.length() != 0) {
                    str.push(dir);
                }
            }

            Stack<String >str1 =new Stack<>();
            while (!str.empty()){
                str1.push(str.pop());
            }
            while (!str1.empty()){
                if(str1.size() !=1)
                    res+=(str1.pop()+"/");
                else
                    res+=str1.pop();
            }
            return res;




    }


}
