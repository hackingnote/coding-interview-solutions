public class Solution {

  class Node {
    Node prev = null;
    Node next = null;
    int val;
    int key;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }

  private Node head = new Node(0, 0);
  private Node tail = new Node(0, 0);
  private int capacity;
  private Map<Integer, Node> map;

  // @param capacity, an integer
  public Solution(int capacity) {
    // write your code here
    head.next = tail;
    tail.prev = head;
    this.capacity = capacity;
    this.map = new HashMap<>(capacity);
  }

  // @return an integer
  public int get(int key) {
    // write your code here
    if (!map.containsKey(key)) {
      return -1;
    }
    Node n = map.get(key);
    moveToTail(n);
    return n.val;
  }

  // @param key, an integer
  // @param value, an integer
  // @return nothing
  public void set(int key, int value) {
    // write your code here
    if (map.containsKey(key)) {
      Node n = map.get(key);
      n.val = value;
      moveToTail(n);
    } else {
      if (size() == capacity) {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.prev = head;
      }
      Node newNode = new Node(key, value);
      tail.prev.next = newNode;
      newNode.prev = tail.prev;
      newNode.next = tail;
      tail.prev = newNode;
      map.put(key, newNode);
    }
  }

  private void moveToTail(Node n) {
    n.prev.next = n.next;
    n.next.prev = n.prev;
    tail.prev.next = n;
    n.prev = tail.prev;
    n.next = tail;
    tail.prev = n;
  }

  private int size() {
    int size = 0;
    Node n = head.next;
    while (n != tail) {
      size++;
      n = n.next;
    }
    return size;
  }
}
