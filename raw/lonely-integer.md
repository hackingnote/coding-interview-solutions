Lonely Integer
===

Problem
-------

[HackerRank: Lonely Integer](https://www.hackerrank.com/challenges/lonely-integer)

There are N integers in an array A. All but one integer occur in pairs. Your task is to find out the number that occurs only once.

Solution
--------

Xor: a ^ a = 0, 0 ^ a = 0, a ^ x ^ a = x

Apply Xor to all numbers, the result will be the lonely integer.

