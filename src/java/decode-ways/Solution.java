public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        char[] raw = s.toCharArray();
        int[] input = new int[raw.length];

        if (raw.length == 0) return 0;

        for (int i = 0; i < raw.length; i++) {
            input[i] = raw[i] - '0';
        }

        if (raw.length == 1) {
            if (input[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        int[] cnt = new int[raw.length];
        cnt[0] = 1;
        cnt[1] = input[1] == 0 ? 1 : input[0] * 10 + input[1] <= 26 ? 2 : 1;

        int i = 2;
        while (i < raw.length) {
            if (input[i] == 0) {
                cnt[i] = cnt[i - 2];
                if (input[i - 1] > 2 || input[i + 1] == 0) {
                    return 0;
                }
                cnt[i + 1] = cnt[i];
                i += 2;

            } else {
                if (input[i - 1] * 10 + input[i] <= 26) {
                    cnt[i] = cnt[i - 2] + cnt[i - 1];
                } else {
                    cnt[i] = cnt[i - 1];
                }
                i += 1;
            }
        }
        return cnt[raw.length - 1];
    }
}
