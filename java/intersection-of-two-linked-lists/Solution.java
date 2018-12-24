
/**
 * Definition for singly-linked list.
 * 
 * <pre>
 * public class ListNode {
 *   int val;
 *   ListNode next;
 * 
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param headA: the first list
   * @param headB: the second list
   * @return: a ListNode
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int sizeA = 0, sizeB = 0;
    ListNode ptrA = headA, ptrB = headB;

    while (ptrA != null) {
      ptrA = ptrA.next;
      sizeA++;
    }

    while (ptrB != null) {
      ptrB = ptrB.next;
      sizeB++;
    }

    if (ptrA != ptrB) {
      return null;
    }

    int diff = sizeA - sizeB;
    if (diff > 0) {
      while (diff-- > 0) {
        headA = headA.next;
      }
    } else {
      while (diff++ < 0) {
        headB = headB.next;
      }
    }

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }
}
