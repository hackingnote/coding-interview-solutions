#include <vector>

class Solution {
 public:
  int minPatches(std::vector<int> &nums, int n) {
    unsigned int cnt = 1, idx = 0;
    int ret = 0;
    while (cnt <= n) {
      // Extend the range by adding next missing value.
      if (idx >= nums.size() || cnt < nums[idx]) {
        cnt *= 2;
        ret++;
        continue;
      }
      // Merge two range together if there is intersection.
      // [1, cnt] and [nums[idx], nums[idx]+cnt].
      cnt += nums[idx];
      idx++;
    }
    return ret;
  }
};
