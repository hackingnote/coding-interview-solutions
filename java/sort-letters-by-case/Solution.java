
public class Solution {
    /**
     * @param chars: The letter array you should sort by Case
     * @return: void
     */
    public void sortLetters(char[] chars) {
        int i = 0, j = chars.length - 1;

        while (i < j) {
            while (i < chars.length && chars[i] <= 'z' && chars[i] >= 'a') i++;
            while (j >= 0 && chars[j] <= 'Z' && chars[j] >= 'A') j--;
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }
    }
}

