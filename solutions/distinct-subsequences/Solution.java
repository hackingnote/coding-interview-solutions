public class Solution {
  /**
   * @param S, T: Two string.
   * @return: Count the number of distinct subsequences
   */
  public int numDistinct(String S, String T) {
    char[] s = S.toCharArray();
    char[] t = T.toCharArray();

    if (t.length == 0)
      return 1;

    int[] curr = new int[s.length];
    for (int i = 0; i < s.length; i++) {
      curr[i] = t[0] == s[i] ? 1 : 0;
    }

    for (int i = 1; i < t.length; i++) {
      int[] prev = curr;
      curr = new int[s.length];
      for (int j = i; j < s.length; j++) {
        if (t[i] == s[j]) {
          for (int k = 0; k < j; k++) {
            curr[j] += prev[k];
          }
        }
      }
    }
    int sum = 0;
    for (int i = 0; i < curr.length; i++) {
      sum += curr[i];
    }
    return sum;
  }
}
