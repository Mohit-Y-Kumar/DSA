package TREES;

public class _4_Diameter {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data =data;
            this.left =null;
            this.right =null;
        }
    }

    public static int hight(Node root){
        if(root==null)
            return 0;

        int lh =hight(root.left);
        int rh =hight(root.right);

        return Math.max(lh,rh) +1;

    }
 /*
 Approach 1 O(n^2)
  */
    public static int diameter2(Node root){  // NO(N)-> O(N^2) =
        if (root==null){
            return 0;
        }

        int lDiam =diameter2(root.left);
        int lHt =hight(root.left);
        int rDiam =diameter2(root.right);
        int rHt =hight(root.right);

        int selfDiam =lHt+rHt+1;
        return  Math.max(selfDiam,Math.max(lDiam,rDiam));

    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam =diam;
            this.ht =ht;
        }
    }

    public static Info diameter(Node root){
        if(root==null){
            return new Info(0,0);

        }
        Info leftInfo =diameter(root.left);
        Info  rightInfo =diameter(root.right);

        int diam =Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht =Math.max(leftInfo.ht,rightInfo.ht)+1;

        return new Info(diam,ht);


    }

    public static void main(String[] args) {
        /*
             1
            / \
           2   3
          / \ / \
         4  5 6  7
         */

        Node root =new Node(1);
        root.left =new Node(2);
        root.right =new Node(3);
        root.left.left =new Node(4);
        root.left.right =new Node(5);
        root.right.left =new Node(6);
        root.right.right =new Node(7);
//        System.out.println(diameter2(root));

        System.out.println(diameter(root).diam);

    }
}
