import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      long k = sc.nextLong();
      long n = k / 2;
      System.out.println(k % 2 == 0 ? n * n : n * (n + 1));
    }
    sc.close();
  }
}
