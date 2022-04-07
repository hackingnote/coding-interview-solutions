import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    double sum = 0;
    while (m-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = sc.nextInt();
      sum += (double) (b - a + 1) * k / n;
    }
    System.out.println((long) Math.floor(sum));
  }
}
