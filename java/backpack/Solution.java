public class Solution {
  /**
   * @param m: An integer m denotes the size of a backpack
   * @param A: Given n items with size A[i]
   * @return: The maximum size
   */
  public int backPack(int m, int[] A) {
    boolean[] bag = new boolean[m + 1];
    boolean[] tmp = new boolean[m + 1];
    bag[0] = true;
    for (int n : A) {
      for (int i = 0; i <= m; i++) {
        if (bag[i] && i + n <= m) {
          tmp[i + n] = true;
        }
      }

      for (int i = 0; i <= m; i++) {
        if (tmp[i]) {
          bag[i] = tmp[i];
          tmp[i] = false;
        }
      }
    }

    while (bag[m] == false) {
      m--;
    }

    return m;
  }
}
