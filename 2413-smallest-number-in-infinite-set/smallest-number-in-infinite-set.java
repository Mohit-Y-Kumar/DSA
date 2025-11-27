class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer>set;

    public SmallestInfiniteSet() {
        pq =new  PriorityQueue<>();
        set =new HashSet<>();

        for(int i =1;i<=1000;i++){
            pq.add(i);
            set.add(i);
        }
        
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            return -1;
        }

        int i =pq.poll();
        set.remove(i);
        return i;
        
    }
    
    public void addBack(int num) {
        if(set.contains(num)){
            return;
        }

        set.add(num);
        pq.add(num);
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */