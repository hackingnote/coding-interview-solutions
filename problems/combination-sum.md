# Combination Sum

## Problem

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Notice

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, `a1 ≤ a2 ≤ … ≤ ak`).
The solution set must not contain duplicate combinations.

## Example

Given candidate set `[2,3,6,7]` and target `7`, a solution set is:

```
[7]
[2, 2, 3]
```

## Code(Java)

```java
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An   integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        Arrays.sort(candidates);
        search(result, buffer, candidates, 0, target);
        return result;
    }

    private void search(List<List<Integer>> result, List<Integer> buffer, int[] candidates, int index, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(buffer);
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            List<Integer> copy = new ArrayList<Integer>(buffer);
            copy.add(candidates[i]);
            search(result, copy, candidates, i, target - candidates[i]);
        }
    }
}
```
