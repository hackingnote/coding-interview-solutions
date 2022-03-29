#include <cstdio>
#include <string>

class PrefixTreeNode {
 public:
  PrefixTreeNode(int c) {
    count = c;
    for (int i = 0; i < 26; i++) {
      children[i] = NULL;
    }
  }
  int count;
  PrefixTreeNode *children[26];
};

class ShortestUniquePrefixTree {
 public:
  PrefixTreeNode *root;
  ShortestUniquePrefixTree() { root = new PrefixTreeNode(0); }
  void insert(std::string word) {
    PrefixTreeNode *tmp = root;
    for (int i = 0; i < word.length(); i++) {
      if (tmp->children[word[i] - 'a'] != NULL)

        tmp->children[word[i] - 'a']->count++;
      else
        tmp->children[word[i] - 'a'] = new PrefixTreeNode(1);
      tmp = tmp->children[word[i] - 'a'];
    }
  }
  std::string getShortestUniquePrefix(std::string word) {
    PrefixTreeNode *tmp = root;
    for (int i = 0; i < word.length(); i++) {
      if (tmp->children[word[i] - 'a'] == NULL)
        return "";
      else if (tmp->children[word[i] - 'a']->count == 1)
        return word.substr(0, i + 1);
      else
        tmp = tmp->children[word[i] - 'a'];
    }
    // if(tmp->count>1)
    return "";
  }
};