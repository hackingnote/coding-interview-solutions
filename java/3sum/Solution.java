import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  /**
   * @param nums : Give an array numbers of n integer
   * @return : Find all unique triplets in the array which gives the sum of
   *     zero.
   */
  public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          result.add(
              new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
          while (left < right && nums[left] == nums[left + 1])
            left++;
          while (left < right && nums[right] == nums[right - 1])
            right--;
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}
