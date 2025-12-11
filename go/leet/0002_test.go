package leet

import (
	"testing"
	"github.com/stretchr/testify/assert"
)

func listNodeToNumber(l *ListNode) int {
	number := 0
	decimal := 1
	for l != nil {
		number += l.Val * decimal
		decimal *= 10
		l = l.Next }
	return number }

func numberToListNode(n int) *ListNode {
	node := &ListNode{0, nil}
	tail := node
	num := n
	decimal := 10
	for num != 0 {
		num = num / decimal
		tail.Next = &ListNode{num % decimal, nil}
		tail = tail.Next
		decimal *= 10 }
	return node.Next }

func addTwoNumbersA(l1 *ListNode, l2 *ListNode) *ListNode {
	n1 := listNodeToNumber(l1)
	n2 := listNodeToNumber(l2)
	n := n1 + n2
	return &ListNode{n, nil}
}

func TestAddTwoNumbersA(t *testing.T) {
	assert.Equal(t, 123, listNodeToNumber(&ListNode{3, &ListNode{2, &ListNode{1, nil}}}))
	assert.Equal(t, 123, listNodeToNumber(numberToListNode(123)))

}


/*
Runtime 100.00%
Memory 40.75%
*/