class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        if (n == 1) return a % b;
        
        long result = fastPower(a, b, n / 2);
        
        result = (result * result) % b;
    
        if (n % 2 == 1) {
            result = (result * a) % b;
        } 
   
        return (int)result;
    }
};