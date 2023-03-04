public class Solution {
  /**
   * @param s Roman representation
   * @return an integer
   */
  public int romanToInt(String s) {

    String[] c = new String[] {
        "I",   "II",  "III", "IV", "V",   "VI",   "VII",  "VIII", "IX", "X",
        "XX",  "XXX", "XL",  "L",  "LX",  "LXX",  "LXXX", "XC",   "C",  "CC",
        "CCC", "CD",  "D",   "DC", "DCC", "DCCC", "CM",   "M",    "MM", "MMM"};
    int[] k = new int[] {1,   2,   3,   4,   5,   6,   7,   8,    9,    10,
                         20,  30,  40,  50,  60,  70,  80,  90,   100,  200,
                         300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000};

    int result = 0;
    while (true) {
      int i;
      for (i = c.length - 1; i >= 0; i--) {
        if (s.startsWith(c[i])) {
          result += k[i];
          s = s.substring(c[i].length());
          break;
        }
      }
      if (s.length() == 0) {
        break;
      }
    }
    return result;
  }
}
