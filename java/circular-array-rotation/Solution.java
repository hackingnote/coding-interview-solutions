import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < q; i++) {
      int qq = sc.nextInt();
      int index = (qq - k) % n;
      System.out.println(a[(index < 0 ? index + n : index)]);
    }
    sc.close();
  }
}
