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
    public int maxLevelSum(TreeNode root) {

        if(root ==null) return 0;

        Queue<TreeNode>q =new LinkedList<>();
        q.offer(root);

        int maxsum =Integer.MIN_VALUE;
        int maxlevel =1;
        int currentlevel =1;

        while(!q.isEmpty()){
            int levelsize =q.size();
            int sum =0;

            for(int i =0;i<levelsize;i++){
                TreeNode node =q.poll();
              sum+= node.val;
            
            if(node.left !=null) q.offer(node.left);
            if(node.right !=null) q.offer(node.right);
            }
            
            if(sum>maxsum){
                maxsum =sum;
                maxlevel =currentlevel;
            }
            currentlevel++;
        }
        return maxlevel;
        
    }
}