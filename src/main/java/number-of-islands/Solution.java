
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        int lenX = grid.length;
        int lenY = grid[0].length;
        int cnt = 0;

        boolean[][] visited = new boolean[lenX][lenY];

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    cnt++;
                    Queue<Integer> qx = new LinkedList<>();
                    Queue<Integer> qy = new LinkedList<>();
                    qx.offer(i);
                    qy.offer(j);
                    visited[i][j] = true;
                    while (!qx.isEmpty()) {
                        int x = qx.poll();
                        int y = qy.poll();
                        for (int k = 0; k < 4; k++) {
                            int tx = x + dx[k];
                            int ty = y + dy[k];
                            if (tx >= 0 && tx < lenX
                                    && ty >= 0 && ty < lenY
                                    && grid[tx][ty] && !visited[tx][ty]) {
                                visited[tx][ty] = true;
                                qx.offer(tx);
                                qy.offer(ty);
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}