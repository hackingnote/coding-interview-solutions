#include <vector>

class Solution {
 public:
  void rotate(std::vector<int> &nums, int k) {
    if (nums.empty()) return;
    k %= nums.size();
    if (k == 0) return;
    int i, j, tmp;
    for (i = 0; i < k; i++) {
      tmp = nums[nums.size() - 1];
      for (j = nums.size() - 1; j > 0; j--) {
        nums[j] = nums[j - 1];
      }
      nums[0] = tmp;
    }
  }
};

class Solution {
 public:
  void rotate(std::vector<int> &nums, int k) {
    if (nums.empty()) return;
    k %= nums.size();
    if (k == 0) return;
    int i;
    std::vector<int> tmp;
    for (i = 0; i < nums.size(); i++) tmp.push_back(nums[i]);
    for (i = 0; i < tmp.size(); i++) {
      nums[(i + k) % nums.size()] = tmp[i];
    }
  }
};

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
