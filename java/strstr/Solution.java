class Solution {
  /**
   * Returns a index to the first occurrence of target in source, or -1 if target is not part of
   * source.
   *
   * @param source string to be scanned.
   * @param target string containing the sequence of characters to match.
   */
  public int strStr(String source, String target) {
    if (source == null || target == null) return -1;
    char[] s = source.toCharArray();
    char[] t = target.toCharArray();
    if (t.length == 0) return 0;
    int i, j;
    for (i = 0; i < s.length; i++) {
      for (j = 0; j < t.length; j++) {
        if (i + j >= s.length || s[i + j] != t[j]) {
          break;
        }
      }
      if (j == t.length) return i;
    }

    return -1;
  }
}
