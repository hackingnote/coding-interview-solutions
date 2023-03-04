import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      double a = sc.nextDouble();
      double b = sc.nextDouble();
      System.out.println((int) Math.floor(Math.sqrt(b)) - (int) Math.ceil(Math.sqrt(a)) + 1);
    }
  }
}
