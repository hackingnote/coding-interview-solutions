
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
