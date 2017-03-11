public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(0);

        for (int i = 0; i < n; i ++) {
            int len = result.size();
            int k = 1 << i;
            for (int j = len - 1; j >= 0; j--) {
                result.add(k + result.get(j));
            }
        }

        return result;
    }
}