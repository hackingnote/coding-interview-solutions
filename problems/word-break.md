Word Break
===


Problem
-------

Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Example
-------

Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Note
---------

Challenge
---------

Solution
--------

Code
----

    #!java
    public class Solution {
        public boolean wordBreak(String s, Set<String> dict) {
    
            int size = s.length();
            boolean[] flag = new boolean[size];
    
            for (int i = 0; i < size; i++) {
                if (i == 0 || flag[i-1] == true) {
                    for (int j = i; j < size; j++) {
                        if (dict.contains(s.substring(i, j+1))) {
                            flag[j] = true;
                        }
                    }
                }
            }
    
            return flag[size - 1];
    
        }
    }

    public class Solution {
        /**
         * @param s: A string s
         * @param dict: A dictionary of words dict
         */
        public boolean wordBreak(String s, Set<String> dict) {
            int len = s.length();
            if (len == 0) return true;
            boolean[] flag = new boolean[len];
            flag[0] = true;
            
            for (int i = 0; i < len; i++) {
                if (flag[i] == false) {
                    continue;
                }
                for (String word : dict) {
                    int j = i, k = 0, l = word.length();
                    
                    while (j < len && k < l && s.charAt(j) == word.charAt(k)) {
                        j++;
                        k++;
                    }
                    
                    if (k == l) {
                        if (j == len) {
                            return true;
                        } else {
                            flag[j] = true;
                        }
                    }
                }
            }
            return false;
            
        }
    }
    
Word Break II


    #!java
    public class Solution {
        public List<String> wordBreak(String s, Set<String> dict) {
            int size = s.length();
            List<List<String>> result = new ArrayList<List<String>>(size);
            for (int i = 0; i < size; i++) {
                result.add(new ArrayList<String>());
            }
    
            for (int i = 0; i < size; i++) {
                if (i == 0 || !result.get(i - 1).isEmpty()) {
                    for (int j = i; j < size; j++) {
                        String sub = s.substring(i, j+1);
                        if (dict.contains(sub)) {
                            List<String> list = result.get(j);
                            list.add(sub);
                        }
                    }
                }
            }
    
    
    
            return backtrack(result, new ArrayList<String>(), size - 1);
        }
    
        private List<String> backtrack(List<List<String>> track, List<String> partials, int index) {
            if (index == -1) {
                return partials;
            }
    
            List<String> ret = new ArrayList<String>();
            for (String s : track.get(index)) {
                List<String> tmp = new ArrayList<String>();
                if (partials.size() == 0) {
                    tmp.add(s);
                } else {
                    for (String p : partials) {
                        tmp.add(s + " " + p);
                    }
                }
                ret.addAll(backtrack(track, tmp, index - s.length()));
            }
            return ret;
        }
    }
