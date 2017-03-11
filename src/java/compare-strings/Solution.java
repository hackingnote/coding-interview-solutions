public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] cnt = new int[26];
        for (char c : A.toCharArray()) {
            cnt[c - 'A']++;
        }

        for (char b : B.toCharArray()) {
            if (cnt[b - 'A'] == 0) {
                return false;
            }
            cnt[b - 'A']--;
        }
        return true;
    }
}
