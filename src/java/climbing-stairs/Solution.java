public class Solution {
    private List<Integer> cnt = new ArrayList<Integer>();

    public Solution() {
        cnt.add(0);
        cnt.add(1);
        cnt.add(2);
    }

    public int climbStairs(int n) {
        int size = cnt.size();
        if (n < size) {
            return cnt.get(n);
        }

        for (int i = size; i <= n; i++) {
            cnt.add(cnt.get(i - 1) + cnt.get(i - 2));
        }
        return cnt.get(n);
    }
}

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}
