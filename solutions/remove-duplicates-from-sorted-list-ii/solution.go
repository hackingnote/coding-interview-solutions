package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	dummy := new(ListNode)
	dummy.Next = head
	p := dummy
	for p.Next != nil {
		q := p.Next.Next
		if q == nil || q.Val != p.Next.Val {
			p = p.Next
		} else {
			for q != nil && q.Val == p.Next.Val {
				q = q.Next
			}
			p.Next = q
		}
	}
	return dummy.Next
}
