
/**
 * Definition of Interval:
 * 
 * <pre>
 * public classs Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * </pre>
 */

class Solution {
  /**
   * Insert newInterval into intervals.
   *
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
      if (i == size || (inserted == false && intervals.get(i).start > newInterval.start)) {
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
