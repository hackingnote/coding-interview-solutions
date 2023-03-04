import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int l = scanner.nextInt();
    int r = scanner.nextInt();
    int max = 0;
    for (int i = l; i <= r; i++) {
      for (int j = i + 1; j <= r; j++) {
        int n = i ^ j;
        if (n > max) {
          max = n;
        }
      }
    }
    System.out.println(max);
  }
}
