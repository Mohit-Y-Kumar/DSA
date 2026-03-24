class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n  =nums.length;
        ArrayList<Integer> al =new ArrayList<>();
       HashMap<Integer,Integer> hm = new HashMap<>();
       for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
       }
       for(Map.Entry<Integer,Integer> e: hm.entrySet()){
        if(e.getValue()>1){
            al.add(e.getKey());
        }
       }
       return al;
    }
}