A + B Problem
===

Problem
-------

Write a function that add two numbers A and B. You should not use + or any arithmetic operators.

Notice: There is no need to read data from standard input stream. Both parameters are given in function aplusb, you job is to calculate the sum and return it.


Clarification
-------------

Are a and b both 32-bit integers?
Yes.

Can I use bit operation?
Sure you can.

Example
-------

Given a=1 and b=2 return 3

Challenge
---------

Of course you can just return a + b to get accepted. But Can you challenge not do it like that?

Solution
--------

``+`` is not allowed to use, however we can directly manipulate bits to simulate the plus operation. 

In its binary format, ``1 + 0`` will be ``1``, ``0 + 0`` will be ``0``, ``1 + 1`` will become ``0``, and the carry becomes ``1``. So the result without carry can be calculated by xor ``a ^ b``, and the carry ``a & b``, if carry is not ``0``, shift it left by 1, and add again:
 
```java
while(b != 0) {
    int carry = a & b;
    a = a ^ b;
    b = carry << 1;
}
```



Code(Java)
----------

```java
class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
};
```