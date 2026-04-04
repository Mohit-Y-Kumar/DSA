class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n =encodedText.length();
        StringBuilder sb = new StringBuilder();
        int col =n/rows;
        int idx =0;
        char dp[][] =new char[rows][col];
        for(int i =0;i<rows;i++){
            for(int j =0;j<col;j++){
                   dp[i][j] =encodedText.charAt(idx++);
            }
        }
        for(int c =0;c<col;c++){
            int i =0,j=c;
            while(i<rows && j<col){
                sb.append(dp[i][j]);
                i++; 
                j++;
            }
        }
       while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
        
    }
}