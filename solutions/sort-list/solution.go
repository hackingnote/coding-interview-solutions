package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func sortList(head *ListNode) *ListNode {
	// if there's 0 or 1 node, it is already sorted.
	if head == nil || head.Next == nil {
		return head
	}

	// find the mid point.
	slow, fast := head, head.Next
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// break the list into 2.
	mid := slow.Next
	slow.Next = nil

	// sort the 2 sub lists.
	head = sortList(head)
	mid = sortList(mid)

	// merge the sorted sub lists.
	dummy := new(ListNode)
	ptr := dummy
	for head != nil && mid != nil {
		if head.Val < mid.Val {
			ptr.Next = head
			head = head.Next
		} else {
			ptr.Next = mid
			mid = mid.Next
		}
		ptr = ptr.Next
	}
	if head != nil {
		ptr.Next = head
	}
	if mid != nil {
		ptr.Next = mid
	}
	return dummy.Next
}
