import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    Set<Long> s = new HashSet<>();
    long a = 0, b = 1;
    s.add(a);
    s.add(b);

    while (t-- > 0) {
      long n = sc.nextLong();
      if (n > b) {
        while (b <= n) {
          long c = a + b;
          s.add(c);
          a = b;
          b = c;
        }
      }

      if (s.contains(n)) {
        System.out.println("IsFibo");
      } else {
        System.out.println("IsNotFibo");
      }
    }
    sc.close();
  }
}
