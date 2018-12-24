
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                length += 2;
                for (int j = length - 1; j > i + 2; j--) {
                    string[j] = string[j - 2];
                }
                string[i] = '%';
                string[i + 1] = '2';
                string[i + 2] = '0';
            }
        }
        return length;
    }
}