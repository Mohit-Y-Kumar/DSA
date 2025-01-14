package STACK;

import java.util.Stack;

public class IsPalendrome {
    static  class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
            this.next =null;
        }
    }
public static Node head;
    public static boolean checkpalen(Node head){
        Node temp =head;
        Stack<Integer> s =new Stack<>();
        while (temp!= null){
            s.push(temp.data);
            temp =temp.next;
        }

        while (head != null){
            int i =s.pop();
            if(head.data != i){
              return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 =new Node(10);
        Node n2 =new Node(15);
        Node n3 =new Node(20);
        Node n5 =new Node(10);

        n1.next =n2;
        n2.next =n3;
        n3.next =n5;
//        n4.next =n5;
        System.out.println(checkpalen(n1));
    }
}
