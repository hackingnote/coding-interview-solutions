
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            int v = map1.containsKey(i) ? map1.get(i) : 0;
            map1.put(i, v + 1);    
        }
        
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums2) {
            int v = map2.containsKey(i) ? map2.get(i) : 0;
            map2.put(i, v + 1);    
        }
        
        List<Integer> buffer = new ArrayList<>();
        
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int times = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < times; i++) buffer.add(key);
            }
        }
      
        int[] arr = new int[buffer.size()];
        int k = 0;
        for (int i : buffer) {
            arr[k++] = i;
        }
        
        return arr;
    }
}
