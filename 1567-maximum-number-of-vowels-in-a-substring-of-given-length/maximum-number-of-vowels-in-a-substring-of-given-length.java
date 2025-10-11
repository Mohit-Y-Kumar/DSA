class Solution {
     private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int n =s.length();
        int ans =0,c=0; //c==count

        for(int i =0;i<k;i++){
            if(isVowel(s.charAt(i))){
                c++;
            }
        }
        ans =Math.max(ans,c);
        if(ans==k) return ans;

        for(int i =k;i<n;i++){
            if(isVowel(s.charAt(i))) c++;
            if(isVowel(s.charAt(i-k))) c--;
            ans = Math.max(ans, c);
            
        }
        return ans;
       
        
    }
}