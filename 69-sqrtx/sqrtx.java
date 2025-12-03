class Solution {
    public int mySqrt(int x) {

    if(x ==0)  return 0;
    if(x==1)      return 1;

    int lo =1;
    int hi =x;
    while(lo<=hi){
        int mid = lo+(hi-lo)/2;
        if((long) mid*mid >(long)x){
            hi =mid-1;
        }else if(mid*mid ==x) return mid;
        else{
            lo =mid+1;
        }
    }
        return Math.round(hi);

    }
}