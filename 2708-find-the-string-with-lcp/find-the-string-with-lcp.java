class Solution {
    public int[][] checkLCP(String word){
        int n =word.length();
        int[][] lcp = new int[n][n];
        for(int i =0;i<n;i++){
           lcp[i][n-1] = (word.charAt(i) == word.charAt(n-1)) ? 1 : 0;
        }
        for(int j =0;j<n;j++){
            lcp[n-1][j] = (word.charAt(n-1) == word.charAt(j)) ? 1 : 0;
        }
        for(int i =n-2;i>=0;i--){
            for(int j =n-2;j>=0;j--){
                if(word.charAt(i) == word.charAt(j)){
                lcp[i][j] = 1+ lcp[i+1][j+1];
                    
                }else{
                    lcp[i][j] =0;
                }
            }
        }
        return lcp;

    }

    public String findTheString(int[][] lcp) {
       int n = lcp.length;
      char[] word = new char[n];
      Arrays.fill(word, '$');
     
      for(int i=0;i<n;i++){
            for(int j =0;j<i;j++){
                
                if(lcp[j][i] !=0){
                    word[i] =word[j];
                    break;
                }

            }

            if(word[i] =='$'){
                boolean[] forbidden = new boolean[26];
                Arrays.fill(forbidden, false);
                for(int j=0;j<i;j++){
                    if(lcp[j][i] ==0){
                        forbidden[word[j] -'a'] =true;
                    }
                }

                //a,b,c......z
                for(int idx=0;idx<26;idx++){
                    if(forbidden[idx] ==false){
                        word[i] = (char)(idx + 'a');
                        break;
                    }
                }

                if(word[i] =='$'){
                    return ""; // we could never fill word[i];
                }
            }
        }

       String result = new String(word);
        int[][] newLcp = checkLCP(result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newLcp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return result;

    }
}