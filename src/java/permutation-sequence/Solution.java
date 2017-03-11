
public class Solution {

    private int[] lkp = new int[10];

    private int[] calculate(int n, int k) {
        if (n == 1) {
            int[] result = new int[10];
            result[1] = 1;
            return result;
        }
        int bandwidth = lkp[n] / n;
        Integer current = (int) Math.ceil((double) (k) / bandwidth);

        int remainder = k - (current - 1) * bandwidth;
        int[] result = calculate(n - 1, remainder);
        int size = result.length;
        for (int i = 0; i < size; i++) {
            if (result[i] >= current) {
                result[i]++;
            }
        }
        result[n] = current;
        return result;
    }


    public String getPermutation(int n, int k) {

        lkp[1] = 1;

        for (int p = 2; p <= n; p++) {
            lkp[p] = lkp[p - 1] * p;
        }

        int[] result = calculate(n, k);
        String s = "";
        for (int i = n; i >= 1; i--) {
            s += result[i];
        }
        return s;
    }
}

