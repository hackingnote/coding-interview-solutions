# Word Ladder II

## Problem

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a timeEach intermediate word must exist in the dictionary

Notice: All words have the same length.All words contain only lowercase alphabetic characters.

## Example

Given:

```
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
```

Return

```
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
```

## Code(Java)

```java
public class Solution {
    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        dict.add(end);
        createGraph(start, dict, map);

        List<List<String>> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        Map<String, Integer> distance = new HashMap<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals(end)) continue;
            for (String t : map.get(s)) {
                if (!visited.contains(t)) {
                    queue.offer(t);
                    visited.add(t);
                    distance.put(t, distance.get(s) + 1);
                }
            }
        }
        assemble(result, map, distance, new ArrayList<String>(Arrays.asList(start)), start, end);
        return result;

    }

    private void assemble(List<List<String>> result, Map<String, List<String>> map, Map<String, Integer> distance, List<String> buffer, String s, String end) {
        int currDist = distance.get(s);
        int targetDist = distance.get(end);
        if (currDist == targetDist && s.equals(end)) {
            result.add(buffer);
            return;
        }
        for (String t : map.get(s)) {
            if (distance.get(t) == currDist + 1) {
                List<String> copy = new ArrayList<>(buffer);
                copy.add(t);
                assemble(result, map, distance, copy, t, end);
            }
        }
    }

    private void createGraph(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return;
        List<String> neighbors = new ArrayList<>();
        map.put(s, neighbors);
        for (String t : dict) {
            if (diffByOne(s, t)) {
                neighbors.add(t);
                createGraph(t, dict, map);
            }
        }
    }

    private boolean diffByOne(String a, String b) {
        int len = a.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (cnt > 0) return false;
                cnt++;
            }
        }
        return cnt == 1;
    }
}
```
