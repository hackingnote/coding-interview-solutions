Permutations II
============

LintCode 16: http://www.lintcode.com/en/problem/permutations-ii/

Problem
-------



Given a list of numbers with duplicate number in it. Find all unique permutations.
Have you met this question in a real interview?
Example

For numbers [1,2,2] the unique permutations are:

```
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
```



Solution
--------

```java
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
      
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> buffer = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        perm(result, 0, buffer, visited, nums);
        return result;
    }
    
 

    
    private void perm(List<List<Integer>> result, int level, LinkedList<Integer> buffer, boolean[] visited, int[] nums) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(buffer));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                        continue;
                    }
                    buffer.offerLast(nums[i]);
                    visited[i] = true;
                    perm(result, level + 1, buffer, visited, nums);
                    buffer.pollLast();
                    visited[i] = false;
                }
            }
        }
    }
}



```