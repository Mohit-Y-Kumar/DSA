class Solution {
    List<String> res;

    void backtrack(StringBuilder curr, int n, int open, int close) {
        if (curr.length() == 2 * n) {
            res.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append("("); //choose
            backtrack(curr,n, open + 1, close); //explore
            curr.deleteCharAt(curr.length() - 1); //undo choise

        }
        if(close<open){
            curr.append(")"); //choose
            backtrack(curr,n,open,close+1 );//explore
            curr.deleteCharAt(curr.length()-1); //undo choise
        }

    }

    

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        int open =0;
        int close =0;
        backtrack(new StringBuilder(), n,open,close);
        return res;

    }
}