public class Solution {
  /**
   * @param nums: A list of integers.
   * @return: the median of numbers
   */
  public int[] medianII(int[] nums) {
    PriorityQueue<Integer> small = new PriorityQueue<>();
    PriorityQueue<Integer> large = new PriorityQueue<>();

    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (!large.isEmpty() && nums[i] > large.peek()) {
        small.offer(-large.poll());
        large.offer(nums[i]);
      } else {
        small.offer(-nums[i]);
      }
      if (small.size() > large.size() + 1) {
        large.offer(-small.poll());
      }
      result[i] = -small.peek();
    }
    return result;
  }
}
