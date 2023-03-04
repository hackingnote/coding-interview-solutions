import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      boolean[] b = new boolean[k + 1];
      b[0] = true;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < k; i++) {
        if (b[i]) {
          for (int j = 0; j < n; j++) {
            if (i + a[j] <= k) {
              b[i + a[j]] = true;
            }
          }
        }
      }
      while (!b[k]) k--;
      System.out.println(k);
    }
    sc.close();
  }
}
