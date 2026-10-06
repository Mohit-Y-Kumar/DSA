class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')' && size > 0 && stack[size - 1] == '(') {
                size--;
            } else {
                stack[size++] = ch;
            }
        }
        return size;

    }
}