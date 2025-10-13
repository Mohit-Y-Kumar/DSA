class Solution {
    public int largestAltitude(int[] gain) {
        int maxlen =0, sum =0;
        for(int i =0;i<gain.length;i++){
            sum +=gain[i];
            maxlen =Math.max(maxlen,sum);
            

        }
        return maxlen;
    }
}