/**
 * Definition for ListNode.
 *
 * <pre>
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *
 *   ListNode(int val) {
 *     this.val = val;
 *     this.next = null;
 *   }
 * }
 * </pre>
 */
public class Solution {
  /**
   * @param lists: a list of ListNode
   * @return: The head of one sorted list.
   */
  public ListNode mergeKLists(List<ListNode> lists) {

    if (lists == null || lists.size() == 0) {
      return null;
    }
    Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), cmp);

    ListNode head = new ListNode(0);
    ListNode p = head;

    for (ListNode node : lists) {
      if (node != null) {
        queue.offer(node);
      }
    }

    while (!queue.isEmpty()) {
      ListNode n = queue.poll();
      p.next = n;
      p = p.next;
      if (n.next != null) {
        queue.offer(n.next);
      }
    }

    return head.next;
  }

  public Comparator<ListNode> cmp = new Comparator<ListNode>() {
    @Override
    public int compare(ListNode a, ListNode b) {
      return a.val - b.val;
    }
  };
}
