class Solution {
    int count = 0;
    // Map key must be long to store the large prefix sums
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        // Use Long for HashMap keys
        HashMap<Long, Integer> h = new HashMap<>();
        h.put(0L, 1); // Use 0L for long 0
        
        // Pass long 0 as the initial sum
        // targetSum can remain int since it's used in subtraction, but for safety, it's better to cast it or change the method signature.
        findpath(root, 0L, targetSum, h);
        return count;
    }

    // Use long for sum and convert targetSum to long inside
    private void findpath(TreeNode root, long sum, int targetSum, HashMap<Long, Integer> h) {
        if (root == null) return;

        // Use long for the current node's value for safe addition
        sum += (long)root.val; 
        
        long targetDiff = sum - (long)targetSum;
        
        if (h.containsKey(targetDiff)) {
            count += h.get(targetDiff);
        }
        
        h.put(sum, h.getOrDefault(sum, 0) + 1);

        findpath(root.left, sum, targetSum, h);
        findpath(root.right, sum, targetSum, h);
        
        // Backtrack
        h.put(sum, h.get(sum) - 1);
        // Optional: remove entry if count is 0, but decrementing is sufficient
        // if(h.get(sum) == 0) h.remove(sum);
    }
}