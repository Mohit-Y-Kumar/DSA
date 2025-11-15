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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 =new ArrayList<>();
        ArrayList<Integer> l2 =new ArrayList<>();
        cln(root1,l1);
        cln(root2,l2);
        return l1.equals(l2);

    }
    private void cln(TreeNode root ,  ArrayList<Integer> l){
        if(root==null) return ;

        if(root.left==null && root.right==null){
            l.add(root.val);
        }

        cln(root.left,l);
        cln(root.right,l);
    }
}