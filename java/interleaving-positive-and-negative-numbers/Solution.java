class Solution {
  /**
   * @param A: An integer array.
   * @return: void
   */
  public void rerange(int[] A) {
    int cntPos = 0;
    for (int i : A) {
      if (i > 0)
        cntPos++;
    }

    if (cntPos > A.length - cntPos) {
      // even: pos, odd: neg
      int i = 0, j = 1;
      while (i < A.length && j < A.length) {
        while (A[i] > 0 && i + 2 < A.length)
          i += 2;
        while (A[j] < 0 && j + 2 < A.length)
          j += 2;
        if (A[i] < 0 && A[j] > 0) {
          int tmp = A[i];
          A[i] = A[j];
          A[j] = tmp;
        }
        i += 2;
        j += 2;
      }
    } else {
      // even: neg, odd: pos
      int i = 0, j = 1;
      while (i < A.length && j < A.length) {
        while (A[i] < 0 && i + 2 < A.length)
          i += 2;
        while (A[j] > 0 && j + 2 < A.length)
          j += 2;
        if (A[i] > 0 && A[j] < 0) {
          int tmp = A[i];
          A[i] = A[j];
          A[j] = tmp;
        }
        i += 2;
        j += 2;
      }
    }
  }
}
