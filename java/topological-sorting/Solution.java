/**
 * Definition for Directed graph. class DirectedGraphNode { int label; ArrayList<DirectedGraphNode>
 * neighbors; DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>();
 * } };
 */
public class Solution {
  /**
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code here
    ArrayList<DirectedGraphNode> result = new ArrayList<>();
    Map<Integer, Integer> indegree = new HashMap<>();

    for (DirectedGraphNode node : graph) {
      for (DirectedGraphNode neighbor : node.neighbors) {
        int cnt = indegree.containsKey(neighbor.label) ? indegree.get(neighbor.label) : 0;
        indegree.put(neighbor.label, cnt + 1);
      }
    }

    Queue<DirectedGraphNode> queue = new LinkedList<>();
    for (DirectedGraphNode node : graph) {
      if (!indegree.containsKey(node.label)) {
        queue.add(node);
      }
    }

    while (!queue.isEmpty()) {
      DirectedGraphNode node = queue.poll();
      result.add(node);
      for (DirectedGraphNode neighbor : node.neighbors) {
        int cnt = indegree.get(neighbor.label);
        if (cnt == 1) {
          queue.add(neighbor);
        }
        indegree.put(neighbor.label, cnt - 1);
      }
    }
    return result;
  }
}
