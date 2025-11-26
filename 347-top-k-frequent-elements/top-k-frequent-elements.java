class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
      Map<Integer,Integer>  h = new HashMap<>();

      PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> h.get(a) - h.get(b));

      for(int num: nums){
        h.put(num,h.getOrDefault(num,0)+ 1);
      }
 

for(int key :h.keySet()){
    if(minHeap.size()<k){
        minHeap.offer(key);
    }
   else if(h.get(key)>h.get(minHeap.peek())){
       minHeap.poll();
        minHeap.offer(key);
    }
}
int[] res = new int[k];
int i = 0;
while(!minHeap.isEmpty()){
    res[i++] = minHeap.poll();
}


 


return res;
    }
}