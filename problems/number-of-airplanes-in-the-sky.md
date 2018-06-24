# Number of Airplanes in the Sky

## Problem

Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Notice: If landing and flying happens at the same time, we consider landing should happen at first.

## Example

For interval list

```
[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
```

Return `3`

## Code(Java)

```java
/**
 * Definition of Interval:
 * public class Interval {
 *   int start, end;
 *   Interval(int start, int end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        int size = airplanes.size();
        int[] x = new int[size];
        int[] y = new int[size];
        for (int i = 0; i < size; i++) {
            x[i] = airplanes.get(i).start;
            y[i] = airplanes.get(i).end;
        }

        Arrays.sort(x);
        Arrays.sort(y);

        int max = 0, cnt = 0, j = 0;

        for (int i = 0; i < size; i++) {
            while (y[j] <= x[i]) {
                cnt--;
                j++;
            }
            cnt++;
            max = Math.max(max, cnt);
        }
        return max;
    }
}
```
