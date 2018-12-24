
public class Solution {
  // @param nestedList a list of NestedInteger
  // @return a list of integer
  public List<Integer> flatten(List<NestedInteger> nestedList) {
    // Write your code here
    List<Integer> result = new ArrayList<>();

    for (NestedInteger i : nestedList) {
      if (i.isInteger()) {
        result.add(i.getInteger());
      } else {
        result.addAll(flatten(i.getList()));
      }
    }
    return result;
  }
}
