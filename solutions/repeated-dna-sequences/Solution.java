class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> ans = new ArrayList<>();
    int len = s.length();
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> res = new HashSet<>();
    for (int i = 10; i <= len; ++i) {
      String sub = s.substring(i - 10, i);
      int n = convert(sub);
      if (!res.contains(n)) {
        if (!set.contains(n)) set.add(n);
        else {
          ans.add(sub);
          res.add(n);
        }
      }
    }
    return ans;
  }

  public static int convert(String sub) {
    int res = 0;
    HashMap<Character, Integer> dict = new HashMap<>();
    dict.put('A', 0);
    dict.put('C', 1);
    dict.put('G', 2);
    dict.put('T', 3);
    for (int i = 0; i < 10; ++i) {
      res += dict.get(sub.charAt(i));
      res *= 4;
    }
    return res;
  }
}
