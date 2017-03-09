public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        
        
        int low = 0;
        int high = num.length - 1;
        
        while(num[low] > num[high]) {
            if (low == high - 1) {
                return num[high];
            }
            int mid = (low + high) / 2;
            if (num[low] < num[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return num[low];
    }
}
