
public class Solution {
  public void nextPermutation(int[] num) {
    int k = num.length - 1;
    while (k - 1 >= 0 && num[k - 1] >= num[k]) {
      k--;
    }

    for (int i = 0; i < (num.length - k) / 2; i++) {
      int tmp = num[k + i];
      num[k + i] = num[num.length - 1 - i];
      num[num.length - 1 - i] = tmp;
    }
    if (k != 0) {
      int i = k;

      while (i < num.length && num[k - 1] >= num[i]) {
        i++;
      }

      if (i != num.length) {
        int tmp = num[k - 1];
        num[k - 1] = num[i];
        num[i] = tmp;
      }
    }
  }
}
