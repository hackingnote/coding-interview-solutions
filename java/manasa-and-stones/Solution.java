import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {

      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      Set<Integer> prev = new HashSet<>();
      prev.add(0);

      for (int i = 0; i < n - 1; i++) {
        Set<Integer> curr = new HashSet<>();
        for (Integer v : prev) {
          curr.add(v + a);
          curr.add(v + b);
        }
        prev = curr;
      }
      List<Integer> result = new ArrayList<Integer>();
      result.addAll(prev);
      Collections.sort(result);
      int size = result.size();
      for (int i = 0; i < size; i++) {
        System.out.print(result.get(i));
        if (i != size - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    sc.close();
  }
}
