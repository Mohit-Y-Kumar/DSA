package LinkedList;

import java.security.PublicKey;

public class DoublyLL {

    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data =data;
            this.next =null;
            this.prev =null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add First
    public void addFirst(int data){
     Node newNode =new Node(data);
     size++;

     if (head==null){ //single node
         head=tail =newNode;
         return;
     }
     newNode.next=head;
     head.prev =newNode;
     head =newNode;
    }

    public void addLast(int data){
        Node newNode =new Node(data);
        size++;

            if(head ==null){
                head =tail =newNode;
                return;

            }
            tail.next =newNode;
            newNode.prev =tail;
            newNode.next =null;






    }

    public int removeFirst(){
        if(head ==null){
            System.out.println("DDL is empty");
            return  Integer.MIN_VALUE;
        }
        if(size==1){
            int val =head.data;
            head =tail =null;
            size--;
            return val;
        }

        int val =head.data;
        head =head.next;
        head.prev =null;
        size--;
        return val;
    }


    public void reverse(){
        Node curr =head;
        Node prev =null;
        Node next;

        while (curr != null){

            next = curr.next;
            curr.next =prev;
            curr.prev =next;

            prev =curr;
            curr =next;
        }
        head =prev;
    }


    public void print(){
        Node temp =head;
        while (temp!= null){
            System.out.print(temp.data+"<->");
            temp =temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
DoublyLL dll =new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(dll.size);
        dll.reverse();
        dll.print();

//        dll.removeFirst();
//        dll.print();

//        dll.addLast(5);
//        dll.print();
//        System.out.println(dll.size);



    }
}
