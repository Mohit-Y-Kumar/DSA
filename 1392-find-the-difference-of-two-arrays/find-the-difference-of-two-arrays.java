class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 =new HashSet<>();
        Set<Integer> set2 =new HashSet<>();
        for(int num:nums1){
       set1.add(num);
        }
         for(int num:nums2){
       set2.add(num);
        }
       
       ArrayList <Integer> dif1 =new ArrayList<>();
       ArrayList <Integer> dif2 =new ArrayList<>();
       for(int num:set1){
        if(!set2.contains(num)){
            dif1.add(num);
        }
       }
        for(int num:set2){
        if(!set1.contains(num)){
            dif2.add(num);
        }
       }
   

    List<List<Integer>> res =new ArrayList<>();
    res.add(dif1);
    res.add(dif2);
    return res;

    }
}