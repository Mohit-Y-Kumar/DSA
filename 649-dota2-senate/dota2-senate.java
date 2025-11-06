import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        return play(senate.toCharArray(),senate.length(),0);
    }

    public String play(char[] senators, int len, int count){
        int index = 0;
        for(int i =0;i<len;i++){
            if(senators[i] == 'R'){
                if(count>=0) {
                    senators[index++] = 'R';
                }
                count++;
            } else {
                if(count<=0){
                    senators[index++] = 'D';
                }
                count--;
            }
        }

        if(Math.abs(count) >= index){
            return count > 0 ? "Radiant":"Dire";
        }

        return play(senators,index,count);
    }
}