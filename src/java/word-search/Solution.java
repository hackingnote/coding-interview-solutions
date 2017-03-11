public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board.length == 0 || board[0].length == 0) return false;
        int lenX = board.length;
        int lenY = board[0].length;

        boolean[][] visited = new boolean[lenX][lenY];

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (search(board, visited, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, char[] word, int wordIndex, int x, int y) {
        if (visited[x][y] == true) {
            return false;
        }

        if (board[x][y] != word[wordIndex]) {
            return false;
        }
        if (wordIndex == word.length - 1) {
            return true;
        }
        visited[x][y] = true;
        if (x > 0 && search(board, visited, word, wordIndex + 1, x - 1, y)) {
            return true;
        }

        if (x < board.length - 1 && search(board, visited, word, wordIndex + 1, x + 1, y)) {
            return true;
        }

        if (y > 0 && search(board, visited, word, wordIndex + 1, x, y - 1)) {
            return true;
        }

        if (y < board[0].length - 1 && search(board, visited, word, wordIndex + 1, x, y + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;

    }
}