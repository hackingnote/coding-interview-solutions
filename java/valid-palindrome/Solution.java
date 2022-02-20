public class Solution {
  /**
   * @param s A string
   * @return Whether the string is a valid palindrome
   */
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    char[] c = s.toCharArray();
    int i = 0;
    int j = c.length - 1;
    while (i < j) {
      while (i < c.length && !Character.isLetterOrDigit(c[i])) {
        i++;
      }
      while (j >= 0 && !Character.isLetterOrDigit(c[j])) {
        j--;
      }
      if (i < c.length && j >= 0 &&
          Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
