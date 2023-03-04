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
      for (int i = 1; i < len; i++) {
        if (str.charAt(i) == str.charAt(i - 1)) cnt++;
      }
      System.out.println(cnt);
    }
  }
}
