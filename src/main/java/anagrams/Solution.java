public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(s);
        }

        List<String> result = new ArrayList<String>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.addAll(map.get(key));
            }
        }
        return result;
    }
}
