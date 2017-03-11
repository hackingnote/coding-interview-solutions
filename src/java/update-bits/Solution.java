class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        
        long mask = (~0L << j + 1L) | ((1L << i) - 1L);
        return (int)((n & mask) | (m << i));
    }
}
