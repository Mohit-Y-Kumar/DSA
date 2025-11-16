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
    int maxpath =0;
    void solve(TreeNode root ,int steps,boolean goLeft){
        if(root ==null) return;
        maxpath =Math.max(maxpath,steps);
        if(goLeft ==true){
            solve(root.left,steps+1,false);
            solve(root.right,1,true);
              
        }else{
            solve(root.right,steps+1, true);
            solve(root.left,1,false);
        }


    }
    public int longestZigZag(TreeNode root) {
        
        solve(root,0,true);
        solve(root,0,false);
        return maxpath;
    }
}