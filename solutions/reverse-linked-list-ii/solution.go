package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	dummy := new(ListNode)
	dummy.Next = head

	before := dummy
	for i := 0; i < left-1; i++ {
		before = before.Next
	}

	// Suppose the list in between left and right is
	// further divided into done list and todo list.

	// Originally only the first node is in the done list.
	// This node do not change in the iterations.
	doneTail := before.Next
	for i := 0; i < right-left; i++ {
		// done list is right after the before node.
		doneHead := before.Next
		// todo list is right after the doneTail node.
		todoHead := doneTail.Next
		// The following 3 actions pull `todoHead` in between `before` and `doneHead`
		before.Next = todoHead
		// Skip the deleted todoHead
		doneTail.Next = todoHead.Next
		// Move todoHead before the done list
		todoHead.Next = doneHead
	}
	return dummy.Next

}

func reverseBetween2(head *ListNode, left int, right int) *ListNode {
	dummy := new(ListNode)
	dummy.Next = head

	before := dummy
	for i := 0; i < left-1; i++ {
		before = before.Next
	}

	prev := before
	curr := before.Next
	for i := 0; i < right-left; i++ {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	before.Next.Next = curr.Next
	if right > left {
		curr.Next = prev
	}
	before.Next = curr

	return dummy.Next
}
