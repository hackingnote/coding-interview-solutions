public class Solution {
  /**
   * @param candidates: A list of integers
   * @param target:An integer
   * @return: A list of lists of integers
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> buffer = new ArrayList<>();
    Arrays.sort(candidates);
    search(result, buffer, candidates, 0, target);
    return result;
  }

  private void search(List<List<Integer>> result, List<Integer> buffer, int[] candidates, int index,
      int target) {
    if (target < 0) {
      return;
    }

    if (target == 0) {
      result.add(buffer);
    }

    for (int i = index; i < candidates.length; i++) {
      if (i > 0 && candidates[i] == candidates[i - 1])
        continue;
      List<Integer> copy = new ArrayList<Integer>(buffer);
      copy.add(candidates[i]);
      search(result, copy, candidates, i, target - candidates[i]);
    }

  }
}
