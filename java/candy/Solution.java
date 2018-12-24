public class Solution {
  /**
   * @param ratings Children's ratings
   * @return the minimum candies you must give
   */
  public int candy(int[] ratings) {
    int[] nums = new int[ratings.length];
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        nums[i] = nums[i - 1] + 1;
      }
    }

    for (int i = ratings.length - 1; i > 0; i--) {
      if (ratings[i] < ratings[i - 1]) {
        nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
      }
    }
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    return sum + ratings.length;
  }
}
