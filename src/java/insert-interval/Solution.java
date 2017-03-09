Insert Interval
===


Problem
-------

Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if necessary).

Example
-------

Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].

Challenge
---------

Solution
--------

Code
----

    #!java
    /**
     * Definition of Interval:
     * public classs Interval {
     *     int start, end;
     *     Interval(int start, int end) {
     *         this.start = start;
     *         this.end = end;
     *     }
     */
    
    class Solution {
        /**
         * Insert newInterval into intervals.
         * @param intervals: Sorted interval list.
         * @param newInterval: A new interval.
         * @return: A new sorted interval list.
         */
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            int size = intervals.size();
                
            ArrayList<Interval> result = new ArrayList<>();
            boolean inserted = false;
            
      
        
            int i = 0;
            int j = -1;
            
            while (i < size || inserted == false) {
     
                Interval candidate = null;
                if (i == size || (inserted == false  && intervals.get(i).start > newInterval.start)) {
                    candidate = newInterval; 
                    inserted = true;
                } else {
                    candidate = intervals.get(i);
                    i++;
                }
                
                if (j == -1) {
                    result.add(candidate);
                    j++;
                } else {
                    Interval prev = result.get(j);
                    if (prev.end >= candidate.start) {
                        prev.end = Math.max(candidate.end, prev.end);
                    } else {
                        result.add(candidate);
                        j++;
                    }
                }
            }
            
            return result;
        }
    }
