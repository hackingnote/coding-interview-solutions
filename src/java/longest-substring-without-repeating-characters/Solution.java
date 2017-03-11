public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();

        Map<Character, Boolean> visited = new HashMap<>();
        int begin = 0, end = 0, max = 0;

        while (end < c.length) {
            if (visited.containsKey(c[end]) && visited.get(c[end])) {
                while (c[begin] != c[end]) {
                    visited.put(c[begin], false);
                    begin++;
                }
                begin++;
            }

            visited.put(c[end], true);
            max = Math.max(max, end - begin + 1);
            end++;
        }
        return max;

    }
}