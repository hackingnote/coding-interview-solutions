import java.io.*;
import java.util.*;

public class Solution {

  private static int maxCnt(int[] a, int[] b) {
    int cnt = 0;
    for (int i = 0; i < a.length; i++) {
      cnt += a[i] | b[i];
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      char[] c = sc.next().toCharArray();
      for (int j = 0; j < m; j++) {

        arr[i][j] = c[j] - '0';
      }
    }
    int max = 0;
    int numMax = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int cnt = maxCnt(arr[i], arr[j]);
        if (cnt == max) {
          numMax++;
        } else if (cnt > max) {
          max = cnt;
          numMax = 1;
        }
      }
    }
    System.out.println(max);
    System.out.println(numMax);
    sc.close();
  }
}
