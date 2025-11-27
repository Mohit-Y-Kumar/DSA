class SmallestInfiniteSet {
    TreeSet<Integer>set;
    Integer curr;

    public SmallestInfiniteSet() {
        // pq =new  PriorityQueue<>();
        set =new TreeSet<>();

        curr =1;
        
    }
    
    public int popSmallest() {
        int ans;
        if(!set.isEmpty()){
             ans =set.first();
             set.remove(ans);
        }else{
            ans =curr;
            curr++;
         }

         return ans;

      
        
    }
    
    public void addBack(int num) {
        if(curr <=num || set.contains(num)){
            return;
        }

        set.add(num);
        // pq.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */