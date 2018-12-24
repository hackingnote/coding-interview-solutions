public class Solution {
  /**
   * @param n: Given a decimal number that is passed in as a string
   * @return: A string
   */
  public String binaryRepresentation(String n) {

    String[] s = n.split("\\.");

    List<Character> c = new ArrayList<>();

    double num = Double.parseDouble(n);

    int part1 = (int) num;
    double part2 = Double.parseDouble("0." + s[1]);

    while (part1 > 0) {
      c.add(part1 % 2 == 1 ? '1' : '0');
      part1 /= 2;
    }
    String result1 = "";
    int len = c.size();
    for (int i = len - 1; i >= 0; i--) {
      result1 += c.get(i);
    }

    result1 = result1.isEmpty() ? "0" : result1;

    // result += ".";
    String result2 = "";
    int cnt = 0;
    while (part2 > 0) {
      if (cnt++ == 32) {
        return "ERROR";
      }
      part2 *= 2;
      if (part2 >= 1) {
        result2 += "1";
        part2 -= 1.0;
      } else {
        result2 += "0";
      }
    }

    return result2.isEmpty() ? result1 : result1 + "." + result2;
  }
}
