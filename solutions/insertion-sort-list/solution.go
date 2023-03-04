package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func insertionSortList(head *ListNode) *ListNode {
	sortedHead := new(ListNode)
	for head != nil {
		p := sortedHead
		for p.Next != nil && p.Next.Val < head.Val {
			p = p.Next
		}
		tmp := head.Next
		head.Next = p.Next
		p.Next = head
		head = tmp
	}
	return sortedHead.Next
}
