class Solution {
  /**
   * @param A: An integer array.
   * @param B: An integer array.
   * @return: Cosine similarity.
   */
  public double cosineSimilarity(int[] A, int[] B) {
    if (A.length != B.length) return 2.0;
    double sum = 0.0;
    for (int i = 0; i < A.length; i++) {
      sum += A[i] * B[i];
    }

    long ssA = getSquaredSum(A);
    long ssB = getSquaredSum(B);

    if (ssA == 0 || ssB == 0) return 2.0;

    return sum / (Math.sqrt(ssA) * Math.sqrt(ssB));
  }

  private long getSquaredSum(int[] a) {
    long sum = 0;
    for (int i : a) {
      sum += i * i;
    }
    return sum;
  }
}
