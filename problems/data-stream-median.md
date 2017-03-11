Data Stream Median
===

## Problem

Numbers keep coming, return the median of numbers at every time a new number added.


## Example

For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
For numbers coming list: [2, 20, 100], return [2, 2, 20].

Code(Java)
----------

```java
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
```