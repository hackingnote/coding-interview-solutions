class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int hi = A.length - 2;
        int lo = 1;
        
        while (lo <= hi) {
            int mid = (hi + lo) >>> 1;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            
            if (A[mid] < A[mid - 1]) {
                hi = mid - 1;
            } else if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            }
        }
        return 0;
    }
}
