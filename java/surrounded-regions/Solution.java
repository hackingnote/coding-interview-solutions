public class Solution {
  /**
   * @param board a 2D board containing 'X' and 'O'
   * @return void
   */
  public void surroundedRegions(char[][] board) {

    if (board == null || board.length == 0) {
      return;
    }

    int n = board.length;
    int m = board[0].length;

    boolean[][] visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      if (board[i][0] == 'O') {
        search(board, visited, i, 0);
      }

      if (board[i][m - 1] == 'O') {
        search(board, visited, i, m - 1);
      }
    }

    for (int j = 0; j < m; j++) {
      if (board[0][j] == 'O') {
        search(board, visited, 0, j);
      }

      if (board[n - 1][j] == 'O') {
        search(board, visited, n - 1, j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == '_') {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void search(char[][] board, boolean[][] visited, int x, int y) {

    int n = board.length;
    int m = board[0].length;

    int[] dx = new int[] {1, 0, -1, 0};
    int[] dy = new int[] {0, 1, 0, -1};

    Queue<Integer> qx = new LinkedList<>();
    Queue<Integer> qy = new LinkedList<>();

    qx.offer(x);
    qy.offer(y);
    visited[x][y] = true;

    while (!qx.isEmpty()) {
      int xx = qx.poll();
      int yy = qy.poll();
      board[xx][yy] = '_';

      for (int i = 0; i < 4; i++) {
        int nx = xx + dx[i];
        int ny = yy + dy[i];

        if (nx < n
            && nx >= 0
            && ny < m
            && ny >= 0
            && board[nx][ny] == 'O'
            && visited[nx][ny] == false) {
          qx.offer(nx);
          qy.offer(ny);
          visited[nx][ny] = true;
        }
      }
    }
  }
}

public class Solution {

  private int MAX_QUEUE = 100000;

  public void solve(char[][] board) {
    int xLen = board.length;
    if (xLen == 0) return;
    int yLen = board[0].length;

    int[] qx = new int[MAX_QUEUE];
    int[] qy = new int[MAX_QUEUE];
    int head = 0;
    int tail = 0;
    for (int i = 0; i < xLen; i++) {
      if (board[i][0] == 'O') {
        qx[tail] = i;
        qy[tail] = 0;
        tail++;
      }
      if (board[i][yLen - 1] == 'O') {
        qx[tail] = i;
        qy[tail] = yLen - 1;
        tail++;
      }
    }
    for (int i = 0; i < yLen; i++) {
      if (board[0][i] == 'O') {
        qx[tail] = 0;
        qy[tail] = i;
        tail++;
      }
      if (board[xLen - 1][i] == 'O') {
        qx[tail] = xLen - 1;
        qy[tail] = i;
        tail++;
      }
    }

    int[] dx = new int[] {1, -1, 0, 0};
    int[] dy = new int[] {0, 0, 1, -1};

    while (head != tail) {
      int x = qx[head];
      int y = qy[head];

      board[x][y] = 'N';
      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx >= 0 && nx < xLen && ny >= 0 && ny < yLen && board[nx][ny] == 'O') {
          qx[tail] = nx;
          qy[tail] = ny;
          tail++;
        }
      }
      head++;
    }

    for (int i = 0; i < xLen; i++) {
      for (int j = 0; j < yLen; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'N') {
          board[i][j] = 'O';
        }
      }
    }
  }
}
