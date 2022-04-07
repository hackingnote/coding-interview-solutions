import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {

  private static long N = (long) 1e9 + 7;

  private static BigInteger combi(long n, long r) {
    r = Math.min(n - r, r);
    BigInteger result = BigInteger.ONE;
    for (long i = 0; i < r; i++) {
      result = result.multiply(BigInteger.valueOf(n - i));
    }
    for (long i = 2; i <= r; i++) {
      result = result.divide(BigInteger.valueOf(i));
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      long n = sc.nextLong();
      long m = sc.nextLong();
      BigInteger r = combi(n + m, n);
      r = r.multiply(BigInteger.valueOf(m));
      r = r.divide(BigInteger.valueOf(m + n)).mod(BigInteger.valueOf(N));

      System.out.println(r);
    }
    sc.close();
  }
}
