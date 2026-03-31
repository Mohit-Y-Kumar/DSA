import java.util.*;

class Solution {

    boolean isSame(StringBuilder word, String str2, int i, int m){
        for(int j = 0; j < m; j++){
            if(word.charAt(i) != str2.charAt(j)){
                return false;
            }
            i++;
        }
        return true;
    }

    public String generateString(String str1, String str2) {
        
        int n = str1.length();
        int m = str2.length();

        int N = n + m - 1;

        StringBuilder Word = new StringBuilder(N);

        for(int i = 0; i < N; i++){
            Word.append('$');
        }

        boolean canChange[] = new boolean[N];
        Arrays.fill(canChange, false);

        //  process 'T'
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'T'){
                int i_ = i;
                for(int j = 0; j < m; j++){
                    if(Word.charAt(i_) != '$' && Word.charAt(i_) != str2.charAt(j)){
                        return "";
                    }
                    Word.setCharAt(i_, str2.charAt(j));
                    i_++;
                }
            }
        }

        //  fill remaining with 'a'
        for(int i = 0; i < N; i++){
            if(Word.charAt(i) == '$'){
                Word.setCharAt(i, 'a');
                canChange[i] = true;
            }
        }

        //  process 'F'
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'F'){
                if(isSame(Word, str2, i, m)){
                    
                    boolean changed = false;

                    for(int k = i + m - 1; k >= i; k--){
                        if(canChange[k]){
                            Word.setCharAt(k, 'b');
                            changed = true;
                            break;
                        }
                    }

                    if(!changed){
                        return "";
                    }
                }
            }
        }

        return Word.toString(); 
    }
}