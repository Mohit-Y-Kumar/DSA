package LinkedList;

public class Linkedlist {
    public static class Node{
        int data;
        Node next;

         public Node(int data){
             this.data =data;
             this.next =null;
         }

    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //step1  Create new node
        Node newNode =new Node(data);
        size++;
        if(head == null){ //////if only one node
            head =tail =newNode;
            return;
        }
        //step2 -newNode next =head
        newNode.next =head; //link

        //step3 - head =newNode
        head =newNode;
    }

    public void addLast(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next =newNode;
        tail =newNode;
    }

    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }

        Node newNode =new Node(data);
        size++;
        Node temp =head;
        int i =0;

        while (i<idx-1){
            temp =temp.next;
            i++;
        }

        //i ==idx-1; temp->prev
        newNode.next =temp.next;
        temp.next =newNode;


    }

    public int RemoveFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size ==1) {
            int val =head.data;
            head =tail =null;
            size=0;
            return val;

        }
        int val =head.data;
        head =head.next;
        size--;
        return val;
    }

    public int RemoveLast(){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val =head.data;
            head=tail=null;
            size=0;
            return val;

        }
        //Previous node i ==size-2
        Node prev =head;
        for (int i = 0; i <size-2 ; i++) {
            prev =prev.next;
        }

        int val =prev.next.data; //tail data
        prev.next =null;
        tail =prev;
        size--;
        return val;

    }

    public void reverse(){
        Node prev =null;
        Node curr =tail =head;
        Node next;

        while (curr != null){
            next =curr.next;
            curr.next =prev;
            prev =curr;
            curr=next;
        }
        head =prev;
    }

    public int Itera_Search(int key){ ///O(N)
        Node temp =head;
        int i =0;
        while (temp != null){//key found
            if(temp.data ==key){
                return  i;
            }
            temp =temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public int helper(Node head,int key){ //   o(n)
        if(head ==null){
            return -1;
        }

        if(head.data ==key){
            return 0;
        }
        int idx =helper(head.next,key);
        if(idx ==-1){   //if not found
            return -1;
        }
        return idx+1; //if found

    }

    public int recSearch(int key){
        return helper(head,key);
    }

    public void deleteNthfromEnd(int n){
        //calculate size
        int sz =0;
        Node temp =head;
        while (temp != null){
            temp =temp.next;
            sz++;
        }

        if(n==sz){
            head =head.next;// removeFirst
            return;
        }
        //sz-n
        int i =1;
        int iToFind =sz-n;
        Node prev =head;
        while (i<iToFind){
            prev =prev.next;
            i++;
        }
        prev.next =prev.next.next;
        return;
    }

   //slow fast approach
    public Node findMid(Node head){
        Node slow =head;
        Node fast =head;

        while (fast!=null && fast.next != null){
            slow =slow.next; //+1
            fast =fast.next.next;//  +2

        }
        return slow;  //slow is my midNode
    }

    public boolean checkPalindrome(){
        if(head==null || head.next == null){  //empty or one node
           return true;
        }
        //step 1 =find mid
        Node midNode =findMid(head);
        //step 2 = reverse 2nd half
        Node prev =null;
        Node curr =midNode;
        Node next;
        while (curr != null){
            next =curr.next;
            curr.next =prev;
            prev =curr;
            curr =next;

        }
        Node right =prev; //right half head
        Node left =head;

        //step 3 =check left half and right half
        while (right != null){
            if(left.data != right.data){
                return false;
            }
            left =left.next;
            right =right.next;


        }
        return true;
    }

// mergesort *******************************

    private Node getMid(Node head){
        Node slow =head;
       Node fast =head.next;

        while (fast != null && fast.next != null){
            slow=slow.next;
            fast =fast.next.next;
        }
        return slow;// mid node
    }

    private Node merge(Node head1 , Node head2){
       Node mergedll =new Node(-1);
              Node temp =mergedll;

        while (head1 != null && head2!=null){

            if (head1.data <=head2.data){
                temp.next =head1;
                head1 =head1.next;
                temp =temp.next;
            }else {
                temp.next =head2;
                head2 =head2.next;
                temp =temp.next;
            }
        }
        while (head1 !=null){
            temp.next =head1;
            head1 =head1.next;
            temp =temp.next;
        }
        while (head2 != null){
            temp.next =head2;
            head2 =head2.next;
            temp =temp.next;
        }

        return mergedll.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next == null){
            return head;
        }

        //find mid
        Node mid =getMid(head);
        // left and right MS
        Node rightHead =mid.next;
        mid.next =null;
       Node newLeft =mergeSort(head);
        Node newRight =mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

        public void print(){
        Node temp =head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void zigzag(){
        Node slow =head;
        Node fast =head;

        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid =slow;

        //reverse 2nd Half

        Node curr =mid.next;
        mid.next =null;
        Node prev =null;
        Node next;

        while (curr != null){
            next =curr.next;
            curr.next =prev;
            prev =curr;
            curr =next;
        }

        Node left =head;
        Node right =prev;
        Node nextL,nextR;

        //alt merge -zig-zag merge
        while (left !=null && right !=null){
            nextL =left.next;
            left.next =right;
            nextR =right.next;
            right.next =nextL;

            left =nextL;
            right =nextR;
        }

    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.print();
        ll.zigzag();
        ll.print();
    }

//        ll.head =ll.mergeSort(ll.head);
//        ll.print();
//    }




//    public static void main(String[] args) {
//   Linkedlist ll =new Linkedlist();
//   ll.print();
//   ll.addFirst(2);
//        ll.print();
//
//        ll.addFirst(1);
//        ll.print();
//
//        ll.addLast(3);
//        ll.print();
//
//        ll.addLast(4);
//        ll.print();
//        ll.add(3,9);
//        ll.print();
////        System.out.println(ll.size);
//        ll.RemoveFirst();
//        ll.print();
//        ll.RemoveLast();
//        ll.print();
//        System.out.println(ll.size);
//        System.out.println(ll.Itera_Search(9));
//        System.out.println(ll.recSearch(4));

//        ll.reverse();
//        ll.print();
//        ll.deleteNthfromEnd(3);
//        ll.print();
//
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(1);
////        ll.addLast(1);
//
//        ll.print();
//        System.out.println(ll.checkPalindrome());
//
//    }

}
//