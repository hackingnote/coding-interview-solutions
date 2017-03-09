class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        int cnt = 0;
        while (c != 0) {
            c &= c-1;
            cnt++;
        }
        return cnt;
    }
};
