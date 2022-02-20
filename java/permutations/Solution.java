class Solution {
  /**
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public List<List<Integer>> permute(int[] nums) {
    // write your code here
    this.nums = nums;
    boolean[] visited = new boolean[nums.length];
    LinkedList<Integer> buffer = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    perm(result, 0, buffer, visited);
    return result;
  }

  private int[] nums;

  private void perm(List<List<Integer>> result, int level,
                    LinkedList<Integer> buffer, boolean[] visited) {
    if (level == nums.length) {
      result.add(new ArrayList<Integer>(buffer));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
          buffer.offerLast(nums[i]);
          visited[i] = true;
          perm(result, level + 1, buffer, visited);
          buffer.pollLast();
          visited[i] = false;
        }
      }
    }
  }
}
