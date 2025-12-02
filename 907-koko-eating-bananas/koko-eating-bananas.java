class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int hi  =0;
        for(int pile:piles){
            hi =Math.max(hi,pile);
        }
        int ans =hi;
        while(l<=hi){
          int  mid =l+(hi-l)/2;

            long totalhours =calhour(piles,mid);
            if(totalhours <=h){
                ans =mid;
                hi =mid-1;
            }else{
                l =mid+1;
            }
        }
        return ans;
        
    }
    private  long calhour(int[] arr,int k){
       long totalh =0;
        for(int pile : arr){
            totalh += (long)Math.ceil((double)pile/k);
        }
        return totalh;
    }
}