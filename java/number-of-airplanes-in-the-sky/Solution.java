/**
 * Definition of Interval:
 *
 * <pre>
 * public classs Interval {
 *   int start, end;
 *   Interval(int start, int end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 * </pre>
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
