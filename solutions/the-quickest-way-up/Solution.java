import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String[] ss = sc.next().split(",");
      int s = Integer.valueOf(ss[0]);
      int l = Integer.valueOf(ss[1]);
      Map<Integer, Integer> m = new HashMap<>();
      for (int i = 0; i < s + l; i++) {
        String pair = sc.next();
        // System.out.println(pair);
        String[] raw = pair.split(",");
        int start = Integer.valueOf(raw[0]);
        int end = Integer.valueOf(raw[1]);
        m.put(start, end);
      }

      boolean[] flag = new boolean[101];
      int[] d = new int[101];
      flag[1] = true;

      Queue<Integer> q = new LinkedList<>();
      q.offer(1);
      while (q.peek() != null) {
        Integer h = q.poll();
        for (int i = 1; i <= 6; i++) {

          if (h + i <= 100) {
            int target;
            if (m.containsKey(h + i)) {
              target = m.get(h + i);
            } else {
              target = h + i;
            }
            if (flag[target] == false || d[h] + 1 < d[target]) {
              flag[target] = true;
              q.offer(target);
              d[target] = d[h] + 1;
            }
          }
        }
      }
      System.out.println(d[100]);
    }
  }
}
