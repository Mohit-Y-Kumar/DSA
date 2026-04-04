class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n =encodedText.length();
        StringBuilder sb = new StringBuilder();
        int col =n/rows;
        for(int c =0;c<col;c++){
            for(int j=c;j<n;j+=col+1){
                sb.append(encodedText.charAt(j));
            }
        }
       while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
        
    }
}