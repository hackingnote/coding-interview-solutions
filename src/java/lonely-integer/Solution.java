
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 0;
        while (n-- > 0) {
            result ^= scanner.nextInt();
        }
        System.out.println(result);
    }
}
