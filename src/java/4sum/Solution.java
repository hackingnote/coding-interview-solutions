public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target  : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     * zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            for (int j = i + 1; j < numbers.length - 2; j++) {
                int left = j + 1;
                int right = numbers.length - 1;

                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == target) {
                        ArrayList<Integer> tuple = new ArrayList<>();
                        tuple.add(numbers[i]);
                        tuple.add(numbers[j]);
                        tuple.add(numbers[left]);
                        tuple.add(numbers[right]);
                        if (!result.contains(tuple)) {
                            result.add(tuple);
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}