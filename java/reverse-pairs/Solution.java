public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        if (A.length == 0) return 0;
        return mergeSort(A, 0, A.length - 1);
    }

    private long mergeSort(int[] A, int low, int high) {
        int mid = (low + high) / 2;

        if (low == high) {
            return 0;
        }

        long sum = 0;
        sum += mergeSort(A, low, mid);
        sum += mergeSort(A, mid + 1, high);

        int left = low, right = mid + 1, curr = low;
        int[] tmp = new int[A.length];
        while (left <= mid || right <= high) {
            if (left > mid) {
                tmp[curr++] = A[right++];
            } else if (right > high) {
                tmp[curr++] = A[left++];
            } else if (A[left] <= A[right]) {
                tmp[curr++] = A[left++];
            } else {
                tmp[curr++] = A[right++];
                sum += mid - left + 1;
            }
        }
        for (int i = low; i <= high; i++) {
            A[i] = tmp[i];
        }
        return sum;
    }
}