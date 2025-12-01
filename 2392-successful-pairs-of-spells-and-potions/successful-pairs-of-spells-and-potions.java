class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n =potions.length;
        Arrays.sort(potions);
       
        int m =spells.length;
        int res[] =new int[m];
        for(int i =0;i< m;i++){

             int s =spells[i];
             int l =0;
             int r =n-1;

            while(l<=r){
                int mid =(l+r)/2;
               long prod = s * (long) potions[mid];
               if(prod>=success){
                r =mid-1;
               }else{
                    l =mid+1;
               }

            }
            res[i] =n-l;
        }
        return res;

        


        
    }
}