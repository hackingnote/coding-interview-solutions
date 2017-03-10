Longest Words
===


Problem
-------

Given a dictionary, find all of the longest words in the dictionary.

Example
-------

Given

    {
      "dog",
      "google",
      "facebook",
      "internationalization",
      "blabla"
    }

the longest words are(is) ["internationalization"].

Given

    {
      "like",
      "love",
      "hate",
      "yes"
    }

the longest words are ["like", "love", "hate"].

Note
---------

Challenge
---------

It's easy to solve it in two passes, can you do it in one pass?

Solution
--------



Code(Java)
----------

```java

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        int max = -1;
        for (String word : dictionary) {
            if (word.length() > max) {
                result = new ArrayList<>();
                result.add(word);
                max = word.length();
            } else if (word.length() == max) {
                result.add(word);
            }
        }
        return result;
    }
};
```