public class Solution {
  /**
   * @param A a string
   * @param B a string
   * @return a boolean
   */
  public boolean stringPermutation(String A, String B) {
    char[] a = A.toCharArray();
    char[] b = B.toCharArray();

    Arrays.sort(a);
    Arrays.sort(b);

    return new String(a).equals(new String(b));
  }
}
