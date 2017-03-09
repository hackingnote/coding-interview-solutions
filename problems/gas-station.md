Gas Station
===


Problem
-------

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Example
-------

Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. The starting gas station's index is 2.

Note
---------

The solution is guaranteed to be unique.

Challenge
---------

O(n) time and O(1) extra space

Solution
--------

Code
----

```java
public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int start = 0; start < gas.length; start++) {
            int i = start;
            int g = gas[start];
            while (true) {
                g -= cost[i];
                if (g < 0) break;
                i = (i + 1) % cost.length;
                if (i == start) return i;
                g += gas[i];
            }
        }
        return -1;
    }
}
```