package main

func firstMissingPositive(nums []int) int {
	n := len(nums)

	// Set all negative numbers to `n + 1`,
	// so they are now positive but still out-of-range.
	for i, k := range nums {
		if k <= 0 {
			nums[i] = n + 1
		}
	}

	// If `nums[i]` is within range, set `nums[nums[i] - 1]` to negative.
	// Effectively, if the index `i` appears in `nums`,
	// `nums[i]` should be negative, otherwise positive.
	for _, k := range nums {
		abs := k
		if abs < 0 {
			abs = -abs
		}
		if abs > 0 && abs <= n && nums[abs-1] > 0 {
			nums[abs-1] = -nums[abs-1]
		}
	}

	// Find the first positive number in the processed `nums` array.
	for i, k := range nums {
		if k > 0 {
			return i + 1
		}
	}

	// If not found, all positive numbers are in the array, return `n + 1`.
	return n + 1
}
