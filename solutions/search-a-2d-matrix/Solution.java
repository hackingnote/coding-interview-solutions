public class Solution {
  /**
   * @param matrix, a list of lists of integers
   * @param target, an integer
   * @return a boolean, indicate whether matrix contains target
   */
  public boolean searchMatrix(int[][] matrix, int target) {

    int rowIndex = binarySearchRow(matrix, target);
    if (rowIndex == -1) {
      return false;
    }
    return binarySearchElement(matrix[rowIndex], target);
  }

  private int binarySearchRow(int[][] matrix, int target) {
    int start = 0, end = matrix.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      int[] row = matrix[mid];
      if (target < row[0]) {
        end = mid - 1;
      } else if (target > row[row.length - 1]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  private boolean binarySearchElement(int[] row, int target) {
    int start = 0, end = row.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (target < row[mid]) {
        end = mid - 1;
      } else if (target > row[mid]) {
        start = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
