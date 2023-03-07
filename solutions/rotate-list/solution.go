package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil {
		return head
	}

	dummy := new(ListNode)
	dummy.Next = head

	tmp, size := head, 0
	for tmp != nil {
		tmp, size = tmp.Next, size+1
	}

	k = k % size

	p, q := dummy, dummy
	for i := 0; i < k; i++ {
		p = p.Next
	}
	for p.Next != nil {
		p, q = p.Next, q.Next
	}
	p.Next = dummy.Next
	dummy.Next = q.Next
	q.Next = nil
	return dummy.Next
}
