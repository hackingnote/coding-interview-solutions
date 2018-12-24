public class Solution {
  /**
   * @param digits A digital string
   * @return all posible letter combinations
   */
  public ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> result = new ArrayList<>();
    if (digits.length() == 0) {
      return result;
    }
    result.add("");

    String[] map = new String[] {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    char[] c = digits.toCharArray();
    for (int i = 0; i < c.length; i++) {
      String s = map[c[i] - '0'];
      ArrayList<String> tmp = new ArrayList<>();
      for (char letter : s.toCharArray()) {
        for (String str : result) {
          tmp.add(str + letter);
        }
      }
      result = tmp;
    }
    Collections.sort(result);
    return result;
  }
}
