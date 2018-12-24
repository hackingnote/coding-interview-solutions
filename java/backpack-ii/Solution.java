public class Solution {
  /**
   * @param   m: An integer m denotes the size of a backpack
   * @param A & V: Given n items with size A[i] and value V[i]
   * @return: The maximum value
   */
  public int backPackII(int m, int[] A, int V[]) {
    int[] bag = new int[m + 1];
    for (int k = 0; k < A.length; k++) {
      int n = A[k];
      for (int i = m; i >= 0; i--) {
        if ((i == 0 || bag[i] > 0) && i + n <= m && bag[i + n] < bag[i] + V[k]) {
          bag[i + n] = bag[i] + V[k];
        }
      }
    }
    int max = 0;
    for (int v : bag) {
      max = Math.max(max, v);
    }
    return max;
  }
}
