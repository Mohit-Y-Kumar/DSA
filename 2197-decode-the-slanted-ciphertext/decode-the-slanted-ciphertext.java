class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n =encodedText.length();
        StringBuilder sb = new StringBuilder();
        int col =n/rows;
        
        for (int c = 0; c < col; c++) {
            int r = 0, j = c;
            while (r < rows && j < col) {
                sb.append(encodedText.charAt(r * col + j));
                r++;
                j++;
            }
        }

       while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
        
    }
}