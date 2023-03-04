public class Solution {
  /**
   * @param A: a array of integers
   * @return : return an integer
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    boolean exceeded = false;
    int remember = -1;
    int a = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {

        if (remember == nums[i]) {
          exceeded = true;
        } else {
          remember = nums[i];
          exceeded = false;
        }

        if (exceeded) {
          continue;
        }
      }
      nums[a++] = nums[i];
    }
    return a;
  }
}
