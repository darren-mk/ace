package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/*
Problem 27, Palindrome Detector
Difficulty: easy
Write a function which returns true if the given sequence
is a palindrome. Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(false? (__ '(1 2 3 4 5)))
(true? (__ "racecar"))
(true? (__ [:foo :bar :foo]))
(true? (__ '(1 1 3 3 1 1)))
(false? (__ '(:a :b :c)))
*/

func reverse[T any](coll []T) []T {
	result := make([]T, len(coll))
	for i, item := range coll {
		result[len(coll)-1-i] = item
	}
	return result
}

func areTwoSlicesEqual[T comparable](a, b []T) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}

func palindromeA[T comparable](coll []T) bool {
	return areTwoSlicesEqual(coll, reverse(coll))
}

func TestFocl027(t *testing.T) {
	assert.False(t, palindromeA([]int{1, 2, 3, 4, 5}))
	assert.True(t, palindromeA([]int{1, 2, 3, 2, 1}))
}
