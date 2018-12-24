/**
 * Definition for ListNode public class ListNode { int val; ListNode next; ListNode(int x) { val =
 * x; next = null; } }
 */
public class Solution {
  /**
   * @param hashTable: A list of The first node of linked list
   * @return: A list of The first node of linked list which have twice size
   */
  public ListNode[] rehashing(ListNode[] hashTable) {
    int oldSize = hashTable.length;
    int newSize = 2 * oldSize;
    ListNode[] result = new ListNode[newSize];

    for (int i = 0; i < oldSize; i++) {
      ListNode node = hashTable[i];
      while (node != null) {
        int newHash = hashcode(node.val, newSize);
        if (result[newHash] == null) {
          result[newHash] = new ListNode(node.val);
        } else {
          ListNode p = result[newHash];
          while (p.next != null) p = p.next;
          p.next = new ListNode(node.val);
        }
        node = node.next;
      }
    }
    return result;
  }

  private int hashcode(int key, int capacity) {
    if (key >= 0) {
      return key % capacity;
    } else {
      return (key % capacity + capacity) % capacity;
    }
  }
};
