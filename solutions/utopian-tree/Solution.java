import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    while (n-- > 0) {
      boolean firstCycle = true;
      int c = scanner.nextInt();

      long height = 1;
      while (c-- > 0) {
        if (firstCycle) {
          height *= 2;
        } else {
          height += 1;
        }
        firstCycle = !firstCycle;
      }
      System.out.println(height);
    }
  }
}
