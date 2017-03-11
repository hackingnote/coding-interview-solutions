public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> tuple = new ArrayList<>();
                    tuple.add(numbers[i]);
                    tuple.add(numbers[left]);
                    tuple.add(numbers[right]);
                    if (!result.contains(tuple)) {
                        result.add(tuple);
                    }
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