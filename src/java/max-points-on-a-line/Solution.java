Max Points on a Line
===


Problem
-------

* [LeetCode 149](https://oj.leetcode.com/problems/max-points-on-a-line/)
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.



Traps
-----

Double comparison: use ``==`` to compare double values may result in wrong answer


Code
----


    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    public class Solution {

        private boolean equals(double a, double b) {
            return Math.abs(a - b) < 1e-5? true : false;
        }


        public int maxPoints(Point[] points) {
            Map<Double, Set<Double>> kbmap = new HashMap<Double, Set<Double>>();

            int max = points.length == 0 ? 0 : 1;
            for (int i =0 ; i< points.length;i++) {
                Point p1 = points[i];
                for (int j=i+1;j<points.length;j++) {
                    Point p2 = points[j];
                    int cnt = 0;
                    if (p2.x == p1.x) {
                        for (int t=0;t<points.length;t++) {
                            Point p = points[t];
                            if (p.x == p2.x) {
                                cnt++;
                            }
                        }
                    } else {
                        double k = (double)(p2.y - p1.y) / (double)(p2.x - p1.x);

                        double b = p1.y - k * p1.x;

                        if (kbmap.containsKey(k)) {
                            if (kbmap.get(k).contains(b)) {
                                continue;
                            }
                            kbmap.get(k).add(b);
                        } else {
                            kbmap.put(k, new HashSet<Double>());
                            kbmap.get(k).add(b);
                        }

                        for (int t=0;t<points.length;t++) {
                            Point p = points[t];
                            if (equals(k * p.x + b, p.y)) {
                                cnt++;
                            }
                        }
                    }

                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }
            return max;
        }
    }
