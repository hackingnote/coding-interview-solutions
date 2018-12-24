public class Solution {
    /**
     * @param num: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] num) {
        String[] s = new String[num.length];

        for (int i = 0; i < num.length; i++) {
            s[i] = Integer.valueOf(num[i]).toString();
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(s, comp);

        String result = "";

        for (int i = s.length - 1; i >= 0; i--) {
            result += s[i];
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }
        return result;
    }


}