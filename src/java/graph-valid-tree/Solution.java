public class Solution {
    /**
     * @param n     an integer
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
        while (!queue.isEmpty()) {
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