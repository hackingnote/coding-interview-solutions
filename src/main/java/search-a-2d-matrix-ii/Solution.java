
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;

        int lenX = matrix.length;
        int lenY = matrix[0].length;

        int i = lenX - 1;
        int j = 0;
        int cnt = 0;

        while (i >= 0 && j < lenY) {
            if (matrix[i][j] == target) {
                cnt++;
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }

        return cnt;
    }
}

