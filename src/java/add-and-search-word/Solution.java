public class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode('_');

    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] c = word.toCharArray();
        _addWord(c, 0, root);
    }

    private void _addWord(char[] c, int index, TrieNode node) {
        if (index == c.length) {
            node.endOfWord = true;
            return;
        }
        TrieNode newNode;
        if (node.children.containsKey(c[index])) {
            newNode = node.children.get(c[index]);
        } else {
            newNode = new TrieNode(c[index]);
            node.children.put(c[index], newNode);
        }
        _addWord(c, index + 1, newNode);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] c = word.toCharArray();
        return _search(c, 0, root);
    }

    private boolean _search(char[] c, int index, TrieNode node) {
        if (index == c.length) {
            return node.endOfWord;
        }
        if (c[index] == '.') {
            boolean found = false;
            for (char key : node.children.keySet()) {
                found = found || _search(c, index + 1, node.children.get(key));
            }
            return found;
        }

        if (node.children.containsKey(c[index])) {
            return _search(c, index + 1, node.children.get(c[index]));
        }
        return false;
    }

    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean endOfWord = false;

        public TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<>();
        }
    }

}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");