class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] sortuniqnum=Arrays.stream(arr).distinct().sorted().toArray();
        int rank =1;
       for(int num:sortuniqnum){
        map.put(num,rank++);
       }
       
       
       for(int i =0 ;i<arr.length;i++){
        arr[i] =map.get(arr[i]);
       }
       

      
      return arr;
    }
}