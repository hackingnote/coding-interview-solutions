
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
       
        ListNode fast = dummy;
        ListNode slow = dummy;
       
        while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
        }

        ListNode p = slow.next;
        slow.next = null;
        ListNode prev = null;
        
        
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p1 != null && p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p2 = next2;
            p1 = next1;
        }
       
    }
}
