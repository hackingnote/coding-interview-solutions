public class Solution {
  /**
   * @param numbers : An array of Integer
   * @param target : target = numbers[index1] + numbers[index2]
   * @return : [index1 + 1, index2 + 1] (index1 < index2)
   */
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      map.put(numbers[i], i);
    }

    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(target - numbers[i])) {
        return new int[] {i + 1, map.get(target - numbers[i]) + 1};
      }
    }
    return new int[2];
  }
}
