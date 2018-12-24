
class Solution {
  /**
   * @param n: an integer
   * @return an integer f(n)
   */
  public int fibonacci(int n) {
    int a = 0, b = 1;
    while (--n > 0) {
      int c = a + b;
      a = b;
      b = c;
    }
    return a;
  }
}
