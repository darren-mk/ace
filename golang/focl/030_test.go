package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 30, Compress a Sequence
   Difficulty: easy
   Write a function which removes consecutive duplicates from a sequence.
   (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
   (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
   (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) */

func compressSequence[T comparable](coll []T) []T {
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

func TestFocl030(t *testing.T) {
	assert.Equal(t, []int{1, 2, 3, 2, 3},
		compressSequence([]int{1, 1, 2, 3, 3, 2, 2, 3}))
}
