import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Integer n = sc.nextInt();
      char[] s = n.toString().toCharArray();
      int cnt = 0;
      for (int i = 0; i < s.length; i++) {
        if (s[i] != '0' && n % (s[i] - '0') == 0) {
          cnt++;
        }
      }
      System.out.println(cnt);
    }
    sc.close();
  }
}
