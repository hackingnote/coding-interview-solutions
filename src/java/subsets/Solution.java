Subsets
===


Problem
-------

* [LeetCode 78](https://oj.leetcode.com/problems/subsets/)

Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]




Key Point
---------

** Elements in a subset must be in non-descending order.**

Code
----

    class Solution {
        /**
         * @param S: A set of numbers.
         * @return: A list of lists. All valid subsets.
         */
        public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            
            Arrays.sort(nums);
            result.add(new ArrayList<Integer>());
            
            for (int i = 0; i < nums.length; i++) {
                ArrayList<ArrayList<Integer>> newResult = new ArrayList<>(result);
                for (ArrayList<Integer> list : result) {
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(nums[i]);
                    newResult.add(newList);
                }
                result = newResult;
            }
            return result;
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
            for (List<Integer> l : assemble( S, n + 1, false)) {
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
