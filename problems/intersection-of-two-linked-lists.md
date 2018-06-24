# Intersection of Two Linked Lists

## Problem

Write a program to find the node at which the intersection of two singly linked lists begins.

## Example

The following two linked lists:

```
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3
```

begin to intersect at node `c1`.

## Note

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.

## Challenge

Your code should preferably run in `O(n)` time and use only `O(1)` memory.

## Code(Java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0;
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != null) {
            ptrA = ptrA.next;
            sizeA++;
        }

        while (ptrB != null) {
            ptrB = ptrB.next;
            sizeB++;
        }

        if (ptrA != ptrB) {
            return null;
        }

        int diff = sizeA - sizeB;
        if (diff > 0) {
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            while (diff++ < 0) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
```
