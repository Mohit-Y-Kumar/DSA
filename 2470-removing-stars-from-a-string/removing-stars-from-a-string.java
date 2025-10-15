class Solution {
    public String removeStars(String s) {
        StringBuilder sb =new StringBuilder();
         Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
             
           if (ch == '*') {
                if (!st.isEmpty()) st.pop(); // remove previous char
            } else {
                st.push(ch); // push normal character
            }
        }  
        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
        
        
    }
}