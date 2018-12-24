
public class Solution {
    /**
     * @param A      : an integer sorted array
     * @param target :  an integer to be inserted
     *               return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {

        if (A == null || A.length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0, high = A.length - 1;
        int left, right;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid;
            } else if (A[mid] == target) {
                high = mid;
            } else {
                high = mid - 1;
            }
        }
        left = A[low] == target ? low : high;

        if (A[left] != target) {
            return new int[]{-1, -1};
        }

        low = 0;
        high = A.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else if (A[mid] == target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        right = A[high] == target ? high : low;

        return new int[]{left, right};
    }
}

