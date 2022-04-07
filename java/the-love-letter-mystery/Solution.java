import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    while (n-- > 0) {
      String str = s.next();
      int len = str.length();
      int cnt = 0;
      for (int i = 0; i < len / 2; i++) {
        cnt += Math.abs(str.charAt(i) - str.charAt(len - i - 1));
      }
      System.out.println(cnt);
    }
  }
}
