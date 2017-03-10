O(1) getMin
===


Problem
-------

* [LeetCode 155](https://oj.leetcode.com/problems/min-stack/)


Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.



Solution
--------

A separate minStack.

* push: push to stack as usual; if the new value is smaller or equal to the top of minStack, push to minStack
* pop: pop stack usual; if the top value of the stack is also the top value of minStack, pop minStack as well
* top: return stack top value
* getMin: return minStack top value

Key Points
----------

Duplicates: make sure you push duplicated values to minStack, i.e. push to minStack if the new value is smaller **or equal** to the top of minStack, otherwise this example will fail:


push(1), push (1), pop(), pop()

### x < getLast(minStack)

* push(1):
    * stack: [1]
    * minStack: [1]
* push (1):
    * stack: [1, 1]
    * minStack: [1]
* pop:
    * stack: [1]
    * minStack: []
* pop:
    * stack: []
    * minStack: IndexOutOfBoundsError

### x <= getLast(minStack)

* push(1):
    * stack: [1]
    * minStack: [1]
* push (1):
    * stack: [1, 1]
    * minStack: [1, 1]
* pop:
    * stack: [1]
    * minStack: [1]
* pop:
    * stack: []
    * minStack: []

