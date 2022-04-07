import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    List<Integer> list = new ArrayList<>();
    while (n-- > 0) {
      list.add(sc.nextInt());
    }
    Collections.sort(list);
    int len = list.size();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < len - k - 1; i++) {
      int v = list.get(i + k - 1) - list.get(i);

      min = v < min ? v : min;
    }
    System.out.println(min);
  }
}
