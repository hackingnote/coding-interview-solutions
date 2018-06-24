# Majority Number

## Problem

Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

## Example

Given `[3,1,2,3,2,3,3,4,4,4]` and `k=3`, return `3`.

## Note

There is only one majority number in the array.

## Challenge

`O(n)` time and `O(k)` extra space

## Code(Java)

```java
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k:    As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int n : nums) {
            if (cntMap.containsKey(n)) {
                cntMap.put(n, cntMap.get(n) + 1);
            } else {
                cntMap.put(n, 1);
            }

            if (cntMap.keySet().size() >= k) {
                List<Integer> removeList = new ArrayList<>();
                for (int key : cntMap.keySet()) {
                    int cnt = cntMap.get(key);
                    if (cnt == 1) {
                        removeList.add(key);
                    } else {
                        cntMap.put(key, cnt - 1);
                    }
                }

                for (int key : removeList) {
                    cntMap.remove(key);
                }
            }
        }

        Map<Integer, Integer> newMap = new HashMap<>();

        int max = 0, maxKey = 0;
        for (int key : cntMap.keySet()) {
            newMap.put(key, 0);
        }

        for (int num : nums) {
            if (newMap.containsKey(num)) {
                int cnt = newMap.get(num) + 1;
                newMap.put(num, cnt);
                if (max < cnt) {
                    max = cnt;
                    maxKey = num;
                }
            }
        }

        return maxKey;
    }
}
```
