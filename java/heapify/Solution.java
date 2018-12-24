public class Solution {
  /**
   * @param A: Given an integer array
   * @return: void
   */
  public void heapify(int[] A) {

    for (int i = A.length - 1; i >= 0; i--) {
      siftDown(A, i);
    }
  }

  private void siftDown(int[] a, int k) {
    if (k < a.length) {
      int minIndex = k;
      int left = 2 * k + 1;
      if (left < a.length && a[left] < a[minIndex]) {
        minIndex = left;
      }

      int right = 2 * k + 2;
      if (right < a.length && a[right] < a[minIndex]) {
        minIndex = right;
      }

      if (k != minIndex) {
        swap(a, minIndex, k);
        siftDown(a, minIndex);
      }
    }
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
