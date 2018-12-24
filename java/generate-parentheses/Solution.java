public class Solution {
  /**
   * @param n n pairs
   * @return All combinations of well-formed parentheses
   */
  public ArrayList<String> generateParenthesis(int n) {
    // Write your code here
    ArrayList<String> result = new ArrayList<>();
    generate(result, "", n, 0, 0);
    return result;
  }

  private void generate(ArrayList<String> result, String buffer, int n, int left, int right) {
    if (buffer.length() == n * 2) {
      result.add(buffer);
      return;
    }

    if (left < n) {
      generate(result, buffer + "(", n, left + 1, right);
    }

    if (left > right) {
      generate(result, buffer + ")", n, left, right + 1);
    }
  }
}
