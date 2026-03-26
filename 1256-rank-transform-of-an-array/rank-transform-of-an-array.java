class Solution {
    public int[] arrayRankTransform(int[] arr) 
    {
        int n = arr.length;
        if (n == 0) return arr;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>(n * 2);
        map.put(sorted[0], rank);
        for (int i = 1; i < n; i++)
        {
            if (sorted[i] != sorted[i - 1])
            {
                map.put(sorted[i], ++rank);
            }
        }
        for (int i = 0; i < n; i++)
        {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}