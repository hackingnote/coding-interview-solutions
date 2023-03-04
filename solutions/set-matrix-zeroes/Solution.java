public class Solution {
  /**
   * @param matrix: A list of lists of integers
   * @return: Void
   */
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int n = matrix.length;
    int m = matrix[0].length;

    boolean firstColZero = false;
    boolean firstRowZero = false;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) {
            firstRowZero = true;
          }
          if (j == 0) {
            firstColZero = true;
          }
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstColZero == true) {
      for (int i = 0; i < n; i++) {
        matrix[i][0] = 0;
      }
    }
    if (firstRowZero == true) {
      for (int j = 0; j < m; j++) {
        matrix[0][j] = 0;
      }
    }
  }
}
