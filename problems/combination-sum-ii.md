Combination Sum II
===

## Problem

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

 Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.




## Example

Given candidate set [10,1,6,7,2,1,5] and target 8,
A solution set is: 
[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]


Code(Java)
----------

```java
public class Solution {
    /**
     * @param num:    Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            List<Integer> buffer = new ArrayList<>();
            buffer.add(num[i]);
            search(result, buffer, num, target - num[i], i);
        }
        return new ArrayList<>(result);

    }

    private void search(Set<List<Integer>> result, List<Integer> buffer, int[] num, int target, int level) {
        if (target < 0) return;
        if (target == 0) {
            result.add(buffer);
            return;
        }

        for (int i = level + 1; i < num.length; i++) {
            List<Integer> copy = new ArrayList<>(buffer);
            copy.add(num[i]);
            search(result, copy, num, target - num[i], i);
        }
    }
}
```