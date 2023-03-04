public class Solution {
  /**
   * @param nums: A list of integers
   * @return: A list of integers includes the index of the first number and the
   * index of the last number
   */
  public ArrayList<Integer> subarraySum(int[] nums) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      if (sum == 0) {
        result.add(i);
        result.add(i);
        return result;
      }
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (sum == 0) {
          result.add(i);
          result.add(j);
          return result;
        }
      }
    }
    return result;
  }
}
