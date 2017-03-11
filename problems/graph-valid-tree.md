Graph Valid Tree
===

## Problem

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.



## Example

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Code(Java)
----------

```java
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        //if (edges.length == 0) return true;
Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            Integer x = edges[i][0];
            Integer y = edges[i][1];

            if (!map.containsKey(x)) map.put(x, new HashSet<Integer>());
            if (!map.containsKey(y)) map.put(y, new HashSet<Integer>());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if (!map.containsKey(node)) break;
            for (int k : map.get(node)) {

                if (visited[k]) {
                    return false;
                }
                visited[k] = true;
                map.get(k).remove(node);
                queue.offer(k);

            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}
```