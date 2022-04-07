import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] s = sc.next().toCharArray();
    int[] cnt = new int[26];
    for (char c : s) {
      cnt[c - 'a']++;
    }
    int numOdd = 0;
    for (int i : cnt) {
      if (i % 2 == 1) {
        numOdd++;
      }
    }
    if (numOdd > 1) {
      System.out.println("NO");
    } else {
      System.out.println("YES");
    }
    sc.close();
  }
}
