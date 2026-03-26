class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
       for(int num:arr){
        map.put(num,0);
       }
       int rank =1;
       for(int key:map.keySet()){
        map.put(key,rank++);
       }
       for(int i =0 ;i<arr.length;i++){
        arr[i] =map.get(arr[i]);
       }
       

      
      return arr;
    }
}