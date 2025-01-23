package B_S_T;


public class _2_Search_bst {
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
            return root;
        }

        if(root.data>val){
            //left subtree
            root.left =insert(root.left,val);
        }
        if (root.data <val){
            root.right =insert(root.right,val);
        }
        return root;
    }

   public static boolean searchBst(Node root,int val){
        if(root ==null){
            return false;
        }
        if(root.data ==val){
            return true;
        }
        if(root.data>val){
            //left sub tree
            return searchBst(root.left,val);
        }
        else{
            return searchBst(root.right,val);
        }
   }
    public static void inOrder(Node root){
        if(root ==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int values[] ={5,1,3,4,2,7};
        Node root =null;
        for (int i = 0; i <values.length ; i++) {
            root =insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();
       if(searchBst(root,6)){
           System.out.println("Found");
       }else {
           System.out.println("Not Found");
       }
    }
}

