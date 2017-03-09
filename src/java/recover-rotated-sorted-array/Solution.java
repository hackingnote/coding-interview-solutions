
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int size = nums.size();
        int i;
        for (i = 1; i < size; i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                break;
            }
        }

        reverse(nums, 0, i - 1);
        reverse(nums, i, size - 1);
        reverse(nums, 0, size - 1);
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
            i++;
            j--;
        }
    }
}