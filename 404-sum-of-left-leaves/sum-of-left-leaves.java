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
     
    //  return leaf(root,null);
     return leaf(root,false);
       
        
       
    }
    // public int leaf(TreeNode root,TreeNode parent){
    public int leaf(TreeNode root,boolean isLeft){


        if(root ==null){
            return 0;
        }
          
        if(root.left==null && root.right==null && isLeft ==true ){
            // if(parent !=null && parent.left ==root){
                return root.val;
            // }
        }
        
        int left =leaf(root.left,true);
        int right =leaf(root.right,false);
        return left+right;



    }
}