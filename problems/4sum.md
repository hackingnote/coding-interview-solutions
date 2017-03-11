4Sum
===


Problem
-------

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

Example
-------

Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

    (-1, 0, 0, 1)
    (-2, -1, 1, 2)
    (-2, 0, 0, 2)

Note
---------

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

Challenge
---------



Solution
--------


Code(Java)
----------

```java
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
```