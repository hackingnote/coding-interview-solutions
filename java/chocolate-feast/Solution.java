import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int m = sc.nextInt();
      int wrappers = n / c;
      int sum = wrappers;
      while (wrappers >= m) {
        sum += wrappers / m;
        wrappers = wrappers / m + wrappers % m;
      }
      System.out.println(sum);
    }
  }
}
