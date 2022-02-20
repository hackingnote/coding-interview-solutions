public class Solution {
  /**
   * @param strs: A list of strings
   * @return: The longest common prefix
   */
  public String longestCommonPrefix(String[] strs) {

    if (strs == null || strs.length == 0)
      return "";

    String shortest = strs[0];

    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < shortest.length()) {
        shortest = strs[i];
      }
    }

    int len = shortest.length();

    for (int i = 0; i < len; i++) {
      boolean same = true;
      for (int j = 0; j < strs.length; j++) {
        if (shortest.charAt(i) != strs[j].charAt(i)) {
          same = false;
          break;
        }
      }
      if (same == false) {
        if (i == 0) {
          return "";
        } else {
          return shortest.substring(0, i);
        }
      }
    }
    return shortest;
  }
}
