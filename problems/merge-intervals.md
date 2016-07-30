Merge Intervals
===


Problem
-------

Given a collection of intervals, merge all overlapping intervals.

Example
-------

Given intervals => merged intervals:

    [                     [
      [1, 3],               [1, 6],
      [2, 6],      =>       [8, 10],
      [8, 10],              [15, 18]
      [15, 18]            ]
    ]

Note
---------

Challenge
---------

O(n log n) time and O(1) extra space.

Solution
--------

Code
----

    #!java
    /**
     * Definition of Interval:
     * public class Interval {
     *     int start, end;
     *     Interval(int start, int end) {
     *         this.start = start;
     *         this.end = end;
     *     }
     */
    
    class Solution {
        /**
         * @param intervals: Sorted interval list.
         * @return: A new sorted interval list.
         */
        public List<Interval> merge(List<Interval> intervals) {
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    return a.start - b.start; 
                }
            });
            
            List<Interval> result = new ArrayList<Interval>();
            
            int size = intervals.size();
            if (size == 1) {
                return intervals;
            }
            for (int i = 1; i < size; i++) {
                if (intervals.get(i - 1).end >= intervals.get(i).start) {
                    intervals.get(i).start = intervals.get(i - 1).start; 
                    intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                    
                } else {
                    result.add(intervals.get(i - 1));
                }
                
                if (i == size - 1) {
                        result.add(intervals.get(i));
                    }
                
            }
            
            return result;
        }
    
    }