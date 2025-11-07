/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow =head,fast =head;
        while(fast!=null && fast.next !=null ){
            slow =slow.next;
            fast =fast.next.next;
        }

        //rev 2nd half
        ListNode revsechalf =reverse(slow);

        ListNode first = head;
        ListNode second = revsechalf;
        int maxx = -1;
        while(second !=null){
            int s =first.val +second.val;
            maxx =Math.max(maxx,s);
            first =first.next;
            second =second.next;

        }
        return maxx;
    }

        public ListNode reverse(ListNode head){
            ListNode prev =null,curr =head,temp ;
            while(curr!=null){
                temp =curr.next;
                curr.next =prev;
                prev =curr;
                curr =temp;
            }
            return prev;


        }

    
}