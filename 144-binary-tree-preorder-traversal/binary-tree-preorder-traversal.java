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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> l =new ArrayList<>();
       preorder(root,l);
       return l;
        
        
    }
    void preorder(TreeNode root,ArrayList<Integer> l){
        if(root ==null){
            return ;
        }

       l.add(root.val);
        preorder(root.left,l);
        preorder(root.right,l);
    }
}