public class Solution {
  /**
   * @param s A string
   * @return the length of last word
   */
  public int lengthOfLastWord(String s) {
    char[] c = s.trim().toCharArray();
    int i = c.length - 1;
    int len = 0;

    while (i >= 0 && c[i] != ' ') {
      i--;
      len++;
    }
    return len;
  }
}
