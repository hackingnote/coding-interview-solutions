Balanced Lineup
===

Problem
-------

[POJ 3264](http://poj.org/problem?id=3264)

### Description

For the daily milking, Farmer John's N cows (1 ≤ N ≤ 50,000) always line up in the same order. One day Farmer John decides to organize a game of Ultimate Frisbee with some of the cows. To keep things simple, he will take a contiguous range of cows from the milking lineup to play the game. However, for all the cows to have fun they should not differ too much in height.

Farmer John has made a list of Q (1 ≤ Q ≤ 200,000) potential groups of cows and their heights (1 ≤ height ≤ 1,000,000). For each group, he wants your help to determine the difference in height between the shortest and the tallest cow in the group.

### Input

Line 1: Two space-separated integers, N and Q.
Lines 2..N+1: Line i+1 contains a single integer that is the height of cow i
Lines N+2..N+Q+1: Two integers A and B (1 ≤ A ≤ B ≤ N), representing the range of cows from A to B inclusive.
Output

Lines 1..Q: Each line contains a single integer that is a response to a reply and indicates the difference in height between the tallest and shortest cow in the range.

### Sample Input

    6 3
    1
    7
    3
    4
    2
    5
    1 5
    4 6
    2 2

### Sample Output

    6
    3
    0

### Source

USACO 2007 January Silver


Solution
--------

RMQ



Code(Java)
----------

```java
import java.util.Scanner;

public class POJ3264 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        int Q = Integer.parseInt(in.next());
        int k = (int)Math.floor(Math.log(N) / Math.log(2));
        int[] height = new int[N];
        int[][] max = new int[N][k + 1];
        int[][] min = new int[N][k + 1];

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(in.next());
            max[i][0] = height[i];
            min[i][0] = height[i];
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < (N  - (1<<(j-1))); i++) {
                max[i][j] = Math.max(max[i][j - 1], max[i + (1 << (j - 1))][j - 1]);
                min[i][j] = Math.min(min[i][j - 1], min[i + (1 << (j - 1))][j - 1]);
            }
        }

        for (int i = 0; i < Q; i++) {
            int a = Integer.parseInt(in.next()) - 1;
            int b = Integer.parseInt(in.next()) - 1;

            if (a == b) {
                System.out.println(0);
            } else {
                int t = (int) Math.floor(Math.log(b - a) / Math.log(2));
                System.out.println(Math.max(max[a][t], max[b - (1 << t) + 1][t]) - Math.min(min[a][t], min[b - (1 << t) + 1][t]));
            }
        }
    }
}


```