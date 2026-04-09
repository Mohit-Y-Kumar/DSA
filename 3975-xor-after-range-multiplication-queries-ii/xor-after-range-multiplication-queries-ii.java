class Solution {
  private static final int mod=1000000007;
    private int power(long a,long b){
        long ans=1;
        while(b>0){
 if((b&1)==1)
     ans=ans*a%mod;
     a=a*a%mod;
            b>>=1;
    
        }
        return (int)ans;
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
    int n=nums.length;
    int T=(int)Math.sqrt(n);
    List<List<int[]>>groups=new ArrayList<>(n);
  for(int i=0;i<T;i++)
      groups.add(new ArrayList<>());
    for(int[]q:queries){
    int l=q[0],r=q[1],k=q[2],v=q[3];
    if(k<T){
        groups.get(k).add(new int[]{l,r,v});
    }else{
    for(int i=l;i<=r;i+=k){
    nums[i]=(int)((long)nums[i]*v%mod);
    }
    }
    }
    long[]diff=new long[T+n];
    for(int k=1;k<T;k++){
        if(groups.get(k).isEmpty())
            continue;
        Arrays.fill(diff,1);
     for(int[]q:groups.get(k)){
    int l=q[0],r=q[1],v=q[2];
    diff[l]=diff[l]*v%mod;
     int R=((r-l)/k+1)*k+l;
    diff[R]=diff[R]*power(v,mod-2)%mod;
     }
    for(int i=k;i<n;i++){
    diff[i]=diff[i]*diff[i-k]%mod;
    }
    for(int i=0;i<n;i++){
    nums[i]=(int)((long)nums[i]*diff[i]%mod);
    }
    }
        int ans=0;
    for(int x:nums)
        ans^=x;
        return ans;
        }
}