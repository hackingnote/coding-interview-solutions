#include <vector>

class Solution {
 public:
  void rotate(std::vector<int> &nums, int k) {
    if (nums.empty()) return;
    k %= nums.size();
    if (k == 0) return;
    int i, j, tmp;
    for (i = 0, j = nums.size() - 1; i < j; i++, j--) {
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    for (i = 0, j = k - 1; i < j; i++, j--) {
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    for (i = k, j = nums.size() - 1; i < j; i++, j--) {
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }
};
