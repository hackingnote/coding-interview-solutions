class Solution {

  private int cnt = 0;

  /**
   * Calculate the total number of distinct N-Queen solutions.
   *
   * @param n: The number of queens.
   * @return: The total number of distinct solutions.
   */
  public int totalNQueens(int n) {
    placeQueen(new int[n], 0, n);
    return cnt;
  }

  private void placeQueen(int[] board, int row, int nQueens) {
    if (row == nQueens) {
      cnt++;
      return;
    }
    for (int i = 0; i < nQueens; i++) {
      board[row] = i;
      if (isValid(board, row)) {
        placeQueen(board, row + 1, nQueens);
      }
    }
  }

  private boolean isValid(int[] board, int row) {
    for (int i = 0; i < row; i++) {
      if (board[i] == board[row] ||
          row - i == Math.abs(board[i] - board[row])) {
        return false;
      }
    }
    return true;
  }
};
