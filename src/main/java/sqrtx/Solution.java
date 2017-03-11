
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 1) return 1;
        long low = 0;
        long high = x;
        while (low < high) {
            long mid = (low + high) / 2;

            if (mid * mid <= x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (int) low;
    }
}