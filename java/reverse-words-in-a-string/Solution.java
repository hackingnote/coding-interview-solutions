public class Solution {
  /**
   * @param s : A string
   * @return : A string
   */
  public String reverseWords(String s) {
    char[] c = s.toCharArray();
    int start = 0, end = 0;
    while (end < c.length) {
      while (end < c.length && c[end] != ' ') {
        end++;
      }
      reverse(c, start, end - 1);
      start = end + 1;
      end++;
    }
    reverse(c, 0, c.length - 1);
    return new String(c).trim();
  }

  private void reverse(char[] c, int start, int end) {
    while (start < end) {
      char tmp = c[start];
      c[start] = c[end];
      c[end] = tmp;
      start++;
      end--;
    }
  }
}
