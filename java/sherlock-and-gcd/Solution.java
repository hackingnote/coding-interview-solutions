import java.io.*;
import java.util.*;

public class Solution {

  private static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      boolean no = true;
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (gcd(a[i], a[j]) == 1) {
            no = false;
          }
        }
      }
      if (no) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
    sc.close();
  }
}
