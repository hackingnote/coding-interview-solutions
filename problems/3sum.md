3Sum
===



Problem
-------

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Example
-------

For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

    (-1, 0, 1)
    (-1, -1, 2)

Note
---------

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Challenge
---------



Solution
--------


Code(Java)
----------

```java
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
```