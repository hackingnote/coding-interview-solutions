Topological Sorting
===================

LintCode 127: http://www.lintcode.com/en/problem/topological-sorting/

Problem
-------

Given an directed graph, a topological order of the graph nodes is defined as follow:

- For each directed edge A -> B in graph, A must before B in the order list.
- The first node in the order can be any node in the graph with no nodes direct to it.

Find any topological order for the given graph.

Notice: You can assume that there is at least one topological order in the graph.

Example
-------

For graph as follow:

![](/images/topological-sorting.jpeg)

The topological order can be:

```
[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
```

Solution
--------


Code(Java)
----------

```java

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 * int label;
 * ArrayList<DirectedGraphNode> neighbors;
 * DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
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

```