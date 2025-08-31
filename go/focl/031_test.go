package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 31, Pack a Sequence
   Difficulty: easy
   Write a function which packs consecutive duplicates into sub-lists.
   (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
   (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
   (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))) */

func packSequence[T comparable](coll []T) []T {
	if len(coll) == 0 {
		return coll
	}
	result := []T{}
	for _, item := range coll {
		l := len(result)
		if l == 0 || item != result[len(result)-1] {
			result = append(result, item)
		}
	}
	return result
}

func TestFocl031(t *testing.T) {
	assert.Equal(t, []int{1, 2, 3, 2, 3},
		compressSequence([]int{1, 1, 2, 3, 3, 2, 2, 3}))
}
