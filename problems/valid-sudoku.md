# Valid Sudoku

## Problem

Determine whether a Sudoku is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character `.`.

## Note

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

## Code(Java)

```java
class Solution {
    /**
     * @param board: the board
     * @return: wether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {

        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<Set<Integer>> blocks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<Integer>());
            cols.add(new HashSet<Integer>());
            blocks.add(new HashSet<Integer>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';

                    if (rows.get(i).contains(k)) {
                        return false;
                    }
                    rows.get(i).add(k);

                    if (cols.get(j).contains(k)) {
                        return false;
                    }
                    cols.get(j).add(k);

                    if (blocks.get(i / 3 * 3 + j / 3).contains(k)) {
                        return false;
                    }
                    blocks.get(i / 3 * 3 + j / 3).add(k);
                }
            }
        }
        return true;
    }
};
```
