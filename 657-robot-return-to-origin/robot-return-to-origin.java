class Solution {
    public boolean judgeCircle(String moves) {
        int n =moves.length();
        int x =0;
        int y =0;
        for(int i =0;i<n;i++){
            if(moves.charAt(i) =='U'){
                x++;
            }
             if(moves.charAt(i) =='R'){
                y++;
            }
             if(moves.charAt(i) =='D'){
                x--;
            }
             if(moves.charAt(i) =='L'){
                y--;
            }
            
            
        }
        if(x==0 && y ==0) return true;
        return false;
    }
}