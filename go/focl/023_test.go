package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 23, Reverse a Sequence
   Difficulty: easy
   Write a function which reverses a sequence.
   (= (__ [1 2 3 4 5]) [5 4 3 2 1])
   (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
   (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) */

func revSeq[T any](coll []T) []T {
	var result []T
	for _, v := range coll {
		result = append([]T{v}, result...)
	}
	return result
}

func TestVoca023Check(t *testing.T) {
	assert.Equal(t, []int{3, 2, 1}, revSeq([]int{1, 2, 3}))
}
