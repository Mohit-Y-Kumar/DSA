class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
    Queue<Integer>pq1 = new PriorityQueue<>();
    Queue<Integer>pq2 = new PriorityQueue<>();
    int i =0,j=costs.length-1;
    long ans =0;

    //who will hire k worker from k cost
    while(k-->0){
        //add pq1 from first candidates from cost
        while(i<=j && pq1.size() < candidates){
            pq1.add(costs[i++]);
        }

        //add pq2 from last candidates from cost
        while(i<=j && pq2.size()<candidates){
            pq2.add(costs[j--]);

        }

        //find min of both pq1 and pq2
        int min1 =pq1.size() >0 ? pq1.peek():Integer.MAX_VALUE;
        int min2 =pq2.size() >0 ? pq2.peek():Integer.MAX_VALUE;

        //then compare and calculate cost min values according to rule

        if(min1<=min2){
            ans+=min1;
            pq1.poll();

        }else{
            ans+=min2;
            pq2.poll();
        }
    }
    return ans;
        
    }
}