public class Solution {
  /**
   * @param matrix a matrix of m x n elements
   * @return an integer list
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }

    int n = matrix.length;
    int m = matrix[0].length;
    int total = n * m;

    boolean[][] visited = new boolean[n][m];

    int[] dx = new int[] {0, 1, 0, -1};
    int[] dy = new int[] {1, 0, -1, 0};
    int cntVisited = 1;
    int i = 0, j = 0, k = 0;
    visited[0][0] = true;
    result.add(matrix[0][0]);

    while (cntVisited != total) {

      int ti = i + dx[k];
      int tj = j + dy[k];
      if (ti < n && ti >= 0 && tj < m && tj >= 0 && visited[ti][tj] == false) {
        visited[ti][tj] = true;
        cntVisited++;
        result.add(matrix[ti][tj]);
        i = ti;
        j = tj;
      } else {
        k = (k + 1) % 4;
      }
    }
    return result;
  }
}
