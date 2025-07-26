package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 20, Penultimate Element
   Difficulty: easy
   Write a function which returns the second
   to last element from a sequence.
   (= (__ (list 1 2 3 4 5)) 4)
   (= (__ ["a" "b" "c"]) "b")
   (= (__ [[1 2] [3 4]]) [1 2]) */

func secondToLastElem[T any](coll []T) T {
	return coll[len(coll)-2]
}

func TestVoca020Check(t *testing.T) {
	assert.Equal(t, 2, secondToLastElem([]int{1, 2, 3}))
}
