class Solution {

    public class Pair {
        int sum;   // this is actually speed
        int min;   // this is actually efficiency
        Pair(int sum ,int min){
            this.sum = sum;
            this.min = min;
        }
    }

    public long maxScore(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; ++i){
            arr[i] = new Pair(speed[i], efficiency[i]);
        }

        // ❌ You sorted by speed.  
        // ✅ Must sort by efficiency DESC.
        Arrays.sort(arr, (a, b) -> b.min - a.min);

        // min-heap by speed (sum)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        long result = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {

            // ❌ You wrote arr[1] (constant index)  
            // ✅ Should be arr[i]
            pq.add(arr[i]);
            sum += arr[i].sum;

            // if more than k, remove smallest speed
            if (pq.size() > k){
                Pair top = pq.remove();
                sum -= top.sum;
            }

            // when team has exactly k members, compute score
            if (pq.size() == k){
                long score = sum * arr[i].min;  // smallest efficiency is arr[i].min
                result = Math.max(result, score);
            }
        }

        return result;
    }
}
