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
   
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root ==null) return root;

        //search node
       

        if(root.val>key){
           root.left= deleteNode( root.left,key);
        }
        else if(root.val<key){ 
            root.right= deleteNode(root.right,key);
        }else{
            // found node -let delete
            //1child
            if(root.left ==null){
            return root.right;
            }
           else if(root.right==null){
             return root.left;
            }
            else{
                //2 child
                TreeNode t =succ(root.right); //find inorder successor
                root.val =t.val;//replace
                root.right =deleteNode(root.right,t.val); //delete successor

            }
        }
        return root;
        
    }
    TreeNode succ(TreeNode root){
        while(root.left !=null) root =root.left;
        return root;

    }
}