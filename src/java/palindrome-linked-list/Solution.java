
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        
        p = head;
        int cnt = 1;
        while (cnt < len / 2) {
            p = p.next;
            cnt++;
        }
        
        ListNode q = p.next;
        while (q != null) {
            
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        for (int i = 0; i < cnt; i++) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }
    
   
}
