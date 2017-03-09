Two Strings Are Anagrams
===


Problem
-------

Write a method anagram(s,t) to decide if two strings are anagrams or not.

Example
-------

Given s="abcd", t="dcab", return true.

Note
---------

Challenge
---------

O(n) time, O(1) extra space

Solution
--------

Code
----

    #!java
    public class Solution {
        /**
         * @param s: The first string
         * @param b: The second string
         * @return true or false
         */
        public boolean anagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }
            
            int[] cnt = new int[256];
            
            int sizeS = s.length();
            int sizeT = t.length();
            if (sizeS != sizeT) {
                return false;
            }
            for (int i = 0; i < sizeS; i++) {
                if (s.charAt(i) != ' ') {
                    cnt[s.charAt(i)]++;
                }
            }
            
            for (int i = 0; i < sizeT; i++) {
                if (t.charAt(i) != ' ') {
                    cnt[t.charAt(i)]--;
                }
            }
            
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) {
                    return false;
                }
            }
            
            return true;
        }
    };