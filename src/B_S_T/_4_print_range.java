package B_S_T;

public class _4_print_range {
    static class Node{
        int data;
      Node left,right;

        public Node(int data){
            this.data =data;
        }
    }

    public static Node insert(Node root,int val){
        if(root ==null){
             root =new Node(val);
        }
        if(root.data <val){
            root.right =insert(root.right,val);

        }
        if(root.data>val){
            root.left =insert(root.left,val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root ==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }
    public static void printRange(Node root,int k1,int k2){
        if(root ==null){
            return ;
        }

        if(root.data>= k1 && root.data <=k2){
            printRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printRange(root.right,k1,k2);
        } else if (root.data>k1) {
            printRange(root.left, k1, k2);

        }else {
            printRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {

        int values[] ={8,5,3,1,4,6,10,11,14};
        Node root =null;

        for (int i = 0; i < values.length; i++) {
            root =insert(root,values[i]);
        }

        inOrder(root);
        System.out.println();
        printRange(root,5,11);
    }

}
