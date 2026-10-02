class Solution {
    List<String> res;

    void backtrack(String curr, int n) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) {
                res.add(curr);
            }
            return;
        }
        // Blindly try putting '(' next
        backtrack(curr + "(", n);

        backtrack(curr + ")", n);
    }

    private boolean isValid(String str) {
        int balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }

        }

        return balance == 0;
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack("", n);
        return res;

    }
}