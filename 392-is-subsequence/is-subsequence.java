class Solution {
    public boolean isSubsequence(String s, String t) {

int m =s.length();
int n =t.length();
int l =0,r =0;
   while(l<m && r<n){
    if(s.charAt(l)==t.charAt(r)){
        l++;
       
    }
    r++;
   }
    if(l==m){
        return true;
    }else{
        return false;
    }
       
    

   
       
    }
}