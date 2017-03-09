
public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] a = new int[n + 1];
        a[0] = 1;
        int[] p = new int[primes.length];
        
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < p.length; j++) {
                min = Math.min(a[p[j]] * primes[j], min);
            }
            //a[i] = Collections.min(Arrays.asList(a[i2] * 2, a[i7] * 7, a[i13] * 13, a[i19] * 19));
            a[i] = min;
            
            for (int j = 0; j < p.length; j++) {
                if (a[i] % primes[j] == 0) {
                    p[j]++;
                }
            }
        
          
        }
        
        return a[n - 1];
        
    }
}
