public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        build(result, new LinkedList<Integer>(), k, n, 1);
        
        return result;
        
    }
    
    private void build(List<List<Integer>> result, LinkedList<Integer> tmp, int k, int n, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        } 
        
        for (int i = start; i <= n; i++) {
            tmp.addLast(i);
            build(result, tmp, k - 1, n, i + 1);
            tmp.removeLast();
        }
    }
}
