package leet

import (
	"testing" )

type ListNode struct {
	Val int
	Next *ListNode }

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	res_node := &ListNode{Val: 0}
	tail_node := res_node
	for list1 != nil || list2 != nil {
		k := 0
		if list1 == nil {
			k = 2
		} else if list2 == nil {
			k = 1
		} else if list1.Val > list2.Val {
			k = 2
		} else {
			k = 1
		}
		if k == 1 {
			tail_node.Next = &ListNode{Val: list1.Val}
			list1 = list1.Next
		} else {
			tail_node.Next = &ListNode{Val: list2.Val}
			list2 = list2.Next
		}
		tail_node = tail_node.Next }
	return res_node.Next }

func buildList(vals []int) *ListNode {
    if len(vals) == 0 {
        return nil }
    head := &ListNode{Val: vals[0]}
    cur := head
    for _, v := range vals[1:] {
        cur.Next = &ListNode{Val: v}
        cur = cur.Next }
    return head }

func toSlice(node *ListNode) []int {
    out := []int{}
    for node != nil {
        out = append(out, node.Val)
        node = node.Next }
    return out }

func TestMergeTwoLists(t *testing.T) {
    l1 := buildList([]int{1, 2, 4})
    l2 := buildList([]int{1, 3, 5})
    got := toSlice(mergeTwoLists(l1, l2))
    want := []int{1, 1, 2, 3, 4, 5}
    if len(got) != len(want) {
        t.Fatalf("expected %v, got %v", want, got) }
    for i := range want {
        if got[i] != want[i] {
            t.Fatalf("expected %v, got %v", want, got) } }
    l1 = buildList([]int{})
    l2 = buildList([]int{7})
    got = toSlice(mergeTwoLists(l1, l2))
    if len(got) != 1 || got[0] != 7 {
        t.Fatalf("expected [7], got %v", got) }
    l1 = buildList([]int{})
    l2 = buildList([]int{})
    got = toSlice(mergeTwoLists(l1, l2))
    if len(got) != 0 {
        t.Fatalf("expected [], got %v", got) } }