class Solution {
    public int longestValidParentheses(String s) {
        int stack[] = new int[s.length() + 1];
        int index = -1;
        int max = 0;
        stack[++index] = -1; //custom stack push

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack[++index] = i;
            } else {
                index--; //pop
                if(index==-1){
                    stack[++index] =i;
                }
                max = Math.max(max, i - stack[index]);
            }
        }
        return max;

    }
}