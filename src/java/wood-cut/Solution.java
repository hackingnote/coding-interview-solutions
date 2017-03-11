public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i : L) {
            max = Math.max(max, i);
        }
        
        int longest = 0;
        int high = max, low = 1;
        
        while (low <= high) {
            int length = low + (high - low) / 2;
            int cnt = 0;
            for (int n : L) {
                cnt += n / length;
            }
            
            if (cnt >= k) {
                longest = Math.max(longest, length);
                low = length + 1;
            } else {
                high = length - 1;
            }
        }
            
            
        
        return longest;
    }
}