public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int k = 0;
        for (int n : A) {
            k ^= n;
        }

        // find 1 in k
        int indexOfOne = 0;
        while (true) {
            if ((k & (1 << indexOfOne)) != 0) break;
            indexOfOne++;
        }

        int n1 = 0, n2 = 0;
        for (int n : A) {
            if (((n >> indexOfOne) & 1) == 1) {
                n1 ^= n;
            } else {
                n2 ^= n;
            }
        }

        return Arrays.asList(n1, n2);
    }
}