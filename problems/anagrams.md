Anagrams
===



Problem
-------

Given an array of strings, return all groups of strings that are anagrams.

Example
-------

Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
---------

All inputs will be in lower-case

Challenge
---------

Solution
--------

Code
----

    #!java
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