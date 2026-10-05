import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        // Change stack to store Integers (scores) instead of Characters
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int count = 0; // This acts as the current layer's score
        
        // FIX 1: Change <= to < to avoid IndexOutOfBoundsException
        for (int i = 0; i < n; i++) { 
            char ch = s.charAt(i);
            
            if (ch == '(') {
                // Save the score of the outer layer before going deeper
                st.push(count);
                // Reset count to calculate the score inside this new layer
                count = 0; 
            } else {
                if (st.isEmpty()) {
                    return 0;
                }
                
                // Retrieve the score of the outer layer
                int outerScore = st.pop();
                
                // FIX 2: Handle nested doubling or base case ()
                // If count is 0, it means we found a base pair "()", which is worth 1.
                // If count > 0, it means we have nested items, so we double it (2 * count).
                int innerScore = (count == 0) ? 1 : 2 * count;
                
                // Add the newly calculated inner score to the outer layer's score
                count = outerScore + innerScore;
            }
        }
        return count;
    }
}
