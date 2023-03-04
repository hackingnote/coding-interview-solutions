import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();

      boolean found = false;
      StringBuilder s = new StringBuilder();
      for (int i = n / 3; i >= 0; i--) {
        if ((n - 3 * i) % 5 == 0) {
          for (int j = i * 3; j > 0; j--) {
            s.append("5");
          }
          for (int j = n - 3 * i; j > 0; j--) {
            s.append("3");
          }
          System.out.println(s);
          found = true;
          break;
        }
      }
      if (!found) {
        System.out.println(-1);
      }
    }
    sc.close();
  }
}
