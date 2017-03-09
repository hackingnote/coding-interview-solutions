
class Solution {

    private ArrayList<ArrayList<String>> result;
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        result = new ArrayList<ArrayList<String>>();
        placeQueen(new int[n], 0, n);
        return result;
    }

    private void placeQueen(int[] board, int row, int nQueens) {
        if (row == nQueens) {
            addToResult(board);
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
            if (board[i] == board[row] || row - i == Math.abs(board[i] - board[row])) {
                return false;
            }
        }
        return true;
    }

    private void addToResult(int[] board) {
        ArrayList<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = "";
            for (int j = 0; j < board.length; j++) {
                if (board[i] == j) {
                    s += 'Q';
                } else {
                    s += '.';
                }
            }
            solution.add(s);
        }
        result.add(solution);
    }

};