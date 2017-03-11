Word Ladder
===


Problem
-------

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Example
-------

Given:

- start = "hit"
- end = "cog"
- dict = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note
---------

- Return 0 if there is no such transformation sequence.
- All words have the same length.
- All words contain only lowercase alphabetic characters.

Challenge
---------

Solution
--------

Code
----


Code(Java)
----------

```java

public class Solution {
    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        dict.add(end);
        queue.offer(start);
        dist.offer(1);
        visited.add(start);
        while (!queue.isEmpty()) {
            String head = queue.poll();
            int dis = dist.poll();
            if (head.equals(end)) {
                return dis;
            }
            for (String s : dict) {
                if (valid(head, s) && !visited.contains(s)) {
                    queue.offer(s);
                    visited.add(s);
                    dist.offer(dis + 1);

                }
            }
        }
        return 0;
    }

    private boolean valid(String a, String b) {
        int len = a.length();
        int cntDiff = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cntDiff++;
            }
        }
        return cntDiff == 1;
    }
}
```