Route Between Two Nodes in Graph
===


Problem
-------

Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

Example
-------

Given graph:

    A----->B----->C
     \     |
      \    |
       \   |
        \  v
         ->D----->E
     
for s = B and t = E, return true

for s = D and t = C, return false

Note
---------

Challenge
---------

Solution
--------



Code(Java)
----------

```java

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        if (s == t) return true;
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                if (visited.contains(n)) continue;
                if (n == t) return true;
                queue.offer(n);
            }
        }
        return false;
    }
}
```