package LinkedList;
import java.util.LinkedList;
public class LL_JCF {
    public static void main(String[] args) {
        LinkedList<Integer> ll =new LinkedList<>();
        ll.addLast(3);
        ll.addFirst(2);
        ll.add(2,9);
        ll.add(1,7);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
