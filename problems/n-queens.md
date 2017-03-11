N-Queens
===


Problem
-------

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example
-------

There exist two distinct solutions to the 4-queens puzzle:

    [
      // Solution 1
      [".Q..",
       "...Q",
       "Q...",
       "..Q."
      ],
      // Solution 2
      ["..Q.",
       "Q...",
       "...Q",
       ".Q.."
      ]
    ]

Note
---------

Challenge
---------

Can you do it without recursion?

Solution
--------



Code(Java)
----------

```java

class Solution {

    private ArrayList<ArrayList<String>> result;

    /**
     * Get all distinct N-Queen solutions
     *
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
```