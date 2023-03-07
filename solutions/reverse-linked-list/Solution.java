class ListNode {
  int val;
  ListNode next;

  ListNode(int val) {
    this.val = val;
    this.next = null;
  }
}

public class Solution {
  /**
   * @param head: The head of linked list.
   * @return: The new head of reversed linked list.
   */
  public ListNode reverse(ListNode head) {
    ListNode a = null;
    ListNode b = head;

    while (b != null) {
      ListNode c = b.next;
      b.next = a;
      a = b;
      b = c;
    }
    return a;
  }
}
