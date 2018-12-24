import java.io.*;
import java.util.*;

// unsigned 32-bit integer
public class Solution2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    while (n-- > 0) {
      long k = scanner.nextLong();
      long s = 0;
      long b = 1;
      for (int i = 0; i < 32; i++) {
        s += (k & 1 ^ 1) * b;
        b *= 2;
        k = k >> 1;
      }
      System.out.println(s);
    }
    scanner.close();
  }
}
