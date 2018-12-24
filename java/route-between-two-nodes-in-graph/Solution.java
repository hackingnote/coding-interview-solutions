/**
 * Definition for Directed graph.
 * 
 * <pre>
 * class DirectedGraphNode {
 *   int label;
 *   ArrayList<DirectedGraphNode> neighbors;
 * 
 *   DirectedGraphNode(int x) {
 *     label = x;
 *     neighbors = new ArrayList<DirectedGraphNode>();
 *   }
 * };
 * </pre>
 */
public class Solution {
  /**
   * @param graph: A list of Directed graph node
   * @param s: the starting Directed graph node
   * @param t: the terminal Directed graph node
   * @return: a boolean value
   */
  public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s,
      DirectedGraphNode t) {
    Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
    if (s == t)
      return true;
    queue.add(s);
    visited.add(s);
    while (!queue.isEmpty()) {
      DirectedGraphNode node = queue.poll();
      for (DirectedGraphNode n : node.neighbors) {
        if (visited.contains(n))
          continue;
        if (n == t)
          return true;
        queue.offer(n);
      }
    }
    return false;
  }
}
