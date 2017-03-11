
class Solution {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int left = 0, right = colors.length - 1;
        int small = 1, big = k;

        while (small < big) {

            for (int i = 0; i <= right; ) {
                if (colors[i] == small) {
                    colors[i] = colors[left];
                    colors[left++] = small;
                    i++;
                } else if (colors[i] == big) {
                    colors[i] = colors[right];
                    colors[right--] = big;
                } else {
                    i++;
                }
            }
            small++;
            big--;
        }
    }
}
