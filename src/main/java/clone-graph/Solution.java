/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * ArrayList<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }
}
