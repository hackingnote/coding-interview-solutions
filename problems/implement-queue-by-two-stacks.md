# Implement Queue by Two Stacks

- [LintCode 40](http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/)
- [LeetCode 232](https://leetcode.com/problems/implement-queue-using-stacks)(under different name)

## Problem

As the title described, you should only use two stacks to implement a queue's actions.

The queue should support `push(element)`, `pop()` and `top()` where `pop` is pop the first(a.k.a front) element in the queue.

Both `pop` and `top` methods should return the value of first element.

## Example

```
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
```

## Challenge

implement it by two stacks, do not use any other data structure and push, pop and top should be `O(1)` by AVERAGE.

## Solution

Queue is first-in-first-out, while stack is first-in-last-out. Since we have two stacks, we can "secretly" reverse the order internally:

- push: add the new element to `stack2`
- pop/top: if `stack1` is not empty, just pop/top from `stack1`; otherwise keep popping from `stack2` and pushing it to `stack1` until `stack2` is empty. So when calling pop/top from `stack1`, the elements are in the same order as they are pushed-in

## Code(Java)

```java
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            move();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            move();
        }
        return stack1.peek();
    }

    private void move() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
```
