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

int ans =0;
  private void find(TreeNode root, int max){
if(root ==null) return;
if(max <=root.val){
    ans++;
    max =root.val;
}
find(root.left,max);
find(root.right,max);
  }
    public int goodNodes(TreeNode root) {
 

 find(root,root.val);
     return ans;   
        
    }
}