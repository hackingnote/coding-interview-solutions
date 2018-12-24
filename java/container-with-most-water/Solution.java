public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int max = 0;
        while (i < j) {
            int height = Math.min(heights[i], heights[j]);
            max = Math.max(max, height * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
