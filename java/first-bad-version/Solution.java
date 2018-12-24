/**
 * <pre>
 * public class SVNRepo {
 *   public static boolean isBadVersion(int k);
 * }
 * </pre>
 * 
 * you can use SVNRepo.isBadVersion(k) to judge whether the kth code version is bad or not.
 */
class Solution {
  /**
   * @param n: An integers.
   * @return: An integer which is the first bad version.
   */
  public int findFirstBadVersion(int n) {

    int i = 1;
    int j = n;
    while (i < j) {
      int m = (i + j) / 2;
      if (SVNRepo.isBadVersion(m)) {
        j = m;
      } else {
        i = m + 1;
      }
    }
    return i;

  }
}
