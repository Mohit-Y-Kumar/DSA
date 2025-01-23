package B_S_T;

import TREES._5_Subtree;

public class _7_Mirror_Bst {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data =data;
        }
    }


    public static Node mirror (Node root){
        if(root ==null){
            return null;
        }
        Node LeftMirror =mirror(root.left);
        Node RightMirror =mirror(root.right);

        root.left =RightMirror;
        root.right =LeftMirror;
        return  root;
    }

    public static void preOrder(Node root){
        if(root ==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);

        preOrder(root.right);


    }

    public static void main(String[] args) {
        /*
             8
            / \
           5   10
          / \  / \
         3   6    11
         */

        Node root =new Node(8);
        root.left =new Node(5);
        root.right =new Node(10);
        root.left.left =new Node(3);
        root.left.right =new Node(6);
        root.right.right =new Node(11);


        /*
             8
            / \
           10   5
          / \  / \
         11  * 6  3
         */

        root =mirror(root);
        preOrder(root);
    }

}
