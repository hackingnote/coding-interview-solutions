public class Solution {
  /**
   * @param s: A string
   * @return: A list of lists of string
   */
  public List<List<String>> partition(String s) {
    char[] c = s.toCharArray();
    List<List<String>> result = new ArrayList<>();
    List<String> buffer = new ArrayList<>();
    search(result, buffer, c, s, 0);
    return result;
  }

  private void search(
      List<List<String>> result, List<String> buffer, char[] c, String s, int index) {

    if (index >= c.length) {
      result.add(buffer);
      return;
    }

    for (int k = index; k < c.length; k++) {
      if (k == index || isPalindrome(c, index, k)) {
        List<String> copy = new ArrayList<>(buffer);
        copy.add(s.substring(index, k + 1));

        search(result, copy, c, s, k + 1);
      }
    }
  }

  private boolean isPalindrome(char[] c, int i, int j) {
    while (i < j) {
      if (c[i] != c[j]) return false;
      i++;
      j--;
    }
    return true;
  }
}
