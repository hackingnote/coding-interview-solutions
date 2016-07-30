Implement Trie
===


Problem
-------

Implement a trie with insert, search, and startsWith methods.

Example
-------

insert("lintcode")
search("code") // return false
startsWith("lint") // return true
startsWith("linterror") // return false
insert("linterror")
search("lintcode) // return true
startsWith("linterror") // return true


Note
---------

You may assume that all inputs are consist of lowercase letters a-z.

Challenge
---------

Solution
--------

Code
----

    #!java
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie trie = new Trie();
     * trie.insert("lintcode");
     * trie.search("lint"); will return false
     * trie.startsWith("lint"); will return true
     */
    class TrieNode {
        // Initialize your data structure here.
        Map<Character, TrieNode> map; 
            char val;
            boolean endOfWord;
            
        public TrieNode() {
            
           
               this.map = new HashMap<>();
               this.endOfWord = false;
            
        }
    }
    
    public class Solution {
        private TrieNode root;
    
        public Solution() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            insert(word, root);
            
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            return search(word, root);
        }
        
        private boolean search(String word, TrieNode node) {
            if (word.length() == 0) {
                if(node.endOfWord == true) {
                return true;
                }
                return false;
            }
            
            if (!node.map.containsKey(word.charAt(0))) {
                return false;
            }
            
            return search(word.substring(1), node.map.get(word.charAt(0)));
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }
        
        private boolean startsWith(String prefix, TrieNode node) {
            if (prefix.length() == 0) {
                return true;
            }
            
            if (!node.map.containsKey(prefix.charAt(0))) {
                return false;
            }
            
            return startsWith(prefix.substring(1), node.map.get(prefix.charAt(0)));
        }
        
        private void insert(String word, TrieNode node) {
    
            char c = word.charAt(0);
            
            if (!node.map.containsKey(c)) {
                node.map.put(c, new TrieNode());
            }
            
            TrieNode n = node.map.get(c);
            n.val = c;
            
            if (word.length() == 1) {
                n.endOfWord = true;
            } else {
                insert(word.substring(1), n);
            }
        }
    }