class Solution {
  /**
   * @param S: A set of numbers.
   * @return: A list of lists. All valid subsets.
   */
  public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

    Collections.sort(S);
    int size = S.size();
    result.add(new ArrayList<Integer>());

    for (int i = 0; i < size; i++) {
      Set<ArrayList<Integer>> newResult = new HashSet<>(result);
      for (ArrayList<Integer> list : result) {
        ArrayList<Integer> newList = new ArrayList<Integer>(list);
        newList.add(S.get(i));
        newResult.add(newList);
      }
      result = newResult;
    }
    ArrayList<ArrayList<Integer>> finalResult = new ArrayList<ArrayList<Integer>>(result);

    return finalResult;
  }
}

public class Solution {

  private List<List<Integer>> assemble(int[] S, int n, boolean included) {
    if (n == S.length - 1) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if (included) {
        result.add(new ArrayList<Integer>());
        return result;
      } else {
        List<Integer> list = new ArrayList<Integer>();
        list.add(S[n]);
        result.add(list);
        return result;
      }
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    for (List<Integer> l : assemble(S, n + 1, true)) {
      List<Integer> list = new ArrayList<Integer>();
      list.addAll(l);
      if (included) {
        list.add(S[n]);
      }
      result.add(list);
    }
    for (List<Integer> l : assemble(S, n + 1, false)) {
      List<Integer> list = new ArrayList<Integer>();
      list.addAll(l);
      if (included) {
        list.add(S[n]);
      }
      result.add(list);
    }

    return result;
  }

  public List<List<Integer>> subsets(int[] S) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    result.addAll(assemble(S, 0, true));
    result.addAll(assemble(S, 0, false));

    for (List<Integer> list : result) {
      Collections.sort(list);
    }

    return result;
  }
}
