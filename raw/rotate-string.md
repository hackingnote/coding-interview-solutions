Rotate String
===

- [LintCode 8](http://www.lintcode.com/en/problem/rotate-string/)

Problem
-------

Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
-------

Given "abcdefg".

    offset=0 => "abcdefg"
    offset=1 => "gabcdef"
    offset=2 => "fgabcde"
    offset=3 => "efgabcd

Challenge
---------

Rotate in-place with O(1) extra memory.


Solution
--------

Reverse the two parts(before and after the offset), then reverse the whole string, then the two parts are swapped, but within each part the characters are still in their original order.