public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int low = 0, high = num.length - 1, mid;


        while (low < high) {

            mid = (low + high) / 2;
            if (num[mid] > num[high]) {
                low = mid + 1;
            } else if (num[mid] < num[high]) {
                high = mid;
            } else {
                high--;
            }

        }

        return num[low];

    }
}