
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {

        int a = 0, b = 0;
        while (b < nums.length) {
            nums[a++] = nums[b++];
            while (b < nums.length && nums[b] == nums[b - 1]) b++;

        }
        return a;
    }
}