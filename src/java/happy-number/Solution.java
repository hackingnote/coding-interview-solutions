public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        Set<Integer> known = new HashSet<>();
        
        while (true) {
            if (n == 1) {
                return true;
            }
            
            known.add(n);
            n = getSum(n);
            if (known.contains(n)) {
                return false;
            }
        }
    }
    
    private int getSum(int n) {
        int s = 0;
        while (n > 0) {
            s += Math.pow(n % 10, 2);
            n /= 10;
        }
        return s;
    }
}
