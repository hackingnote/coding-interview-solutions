class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        long result = 0;
        for (char c : key) {
            result = (result * 33 + (int)c) % HASH_SIZE;
        }
        return (int)result;
    }
};
