/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root ==null) return 0;
        HashMap<Long,Integer> h =new HashMap<>();
        h.put(0L,1);
        findpath(root,0L,targetSum,h);
        return count;

    }
    private void findpath(TreeNode root,long sum,int targetSum,HashMap<Long,Integer> h){
        if(root ==null) return ;

       sum +=root.val;
       if(h.containsKey(sum-targetSum)){
        count += h.get(sum-targetSum);

       }
       h.put(sum,h.getOrDefault(sum,0)+1);
       
        
        findpath(root.left,sum,targetSum,h);
        findpath(root.right,sum,targetSum,h);
        h.put(sum,h.get(sum)-1);
        return;
    }
}