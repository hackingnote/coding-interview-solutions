package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	p := head
	for p != nil {
		q := p.Next
		for q != nil && q.Val == p.Val {
			q = q.Next
		}
		p.Next = q
		p = p.Next
	}
	return head
}
