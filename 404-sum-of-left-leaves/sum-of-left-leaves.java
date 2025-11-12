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
    public int sumOfLeftLeaves(TreeNode root) {
     
     return leaf(root,null);
       
        
       
    }
    public int leaf(TreeNode root,TreeNode parent){
        if(root ==null){
            return 0;
        }
          
          if(root.left==null && root.right==null ){
             if(parent !=null && parent.left ==root){
                return root.val;
             }
            }
        
        int left =leaf(root.left,root);
        int right =leaf(root.right,root);
        return left+right;



    }
}