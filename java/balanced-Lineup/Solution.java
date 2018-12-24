import java.util.Scanner;

public class POJ3264 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = Integer.parseInt(in.next());
    int Q = Integer.parseInt(in.next());
    int k = (int) Math.floor(Math.log(N) / Math.log(2));
    int[] height = new int[N];
    int[][] max = new int[N][k + 1];
    int[][] min = new int[N][k + 1];

    for (int i = 0; i < N; i++) {
      height[i] = Integer.parseInt(in.next());
      max[i][0] = height[i];
      min[i][0] = height[i];
    }

    for (int j = 1; j <= k; j++) {
      for (int i = 0; i < (N - (1 << (j - 1))); i++) {
        max[i][j] = Math.max(max[i][j - 1], max[i + (1 << (j - 1))][j - 1]);
        min[i][j] = Math.min(min[i][j - 1], min[i + (1 << (j - 1))][j - 1]);
      }
    }

    for (int i = 0; i < Q; i++) {
      int a = Integer.parseInt(in.next()) - 1;
      int b = Integer.parseInt(in.next()) - 1;

      if (a == b) {
        System.out.println(0);
      } else {
        int t = (int) Math.floor(Math.log(b - a) / Math.log(2));
        System.out.println(
            Math.max(max[a][t], max[b - (1 << t) + 1][t])
                - Math.min(min[a][t], min[b - (1 << t) + 1][t]));
      }
    }
  }
}
