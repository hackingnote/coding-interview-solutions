public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {

        int len = nums.size();
        ArrayList<Integer> result = new ArrayList<>(len);
        int i;
        for (i = len - 1; i > 0 && nums.get(i) >= nums.get(i - 1); i--) ;
        int j = i - 1;

        if (j < 0) {
            reverse(nums, 0, len - 1);
        } else {
            int k = len - 1;
            while (nums.get(k) >= nums.get(j)) k--;

            int tmp = nums.get(j);
            nums.set(j, nums.get(k));
            nums.set(k, tmp);

            reverse(nums, i, len - 1);
        }

        return nums;
    }

    private void reverse(ArrayList<Integer> nums, int i, int j) {
        while (i < j) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
            i++;
            j--;
        }
    }
}
