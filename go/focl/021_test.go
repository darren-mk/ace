package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 21, Nth Element
   Difficulty: easy
   Write a function which returns the Nth element from a sequence.
   (= (__ '(4 5 6 7) 2) 6)
   (= (__ [:a :b :c] 0) :a)
   (= (__ [1 2 3 4] 1) 2)
   (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])
   Special Restrictions : nth */

func getNthElem[T any](coll []T, n int) T {
	for i, v := range coll {
		if i == n {
			return v
		}
	}
	var zero T
	return zero
}

func TestVoca021Check(t *testing.T) {
	assert.Equal(t, 2, getNthElem([]int{1, 2, 3}, 1))
	assert.Equal(t, 0, getNthElem([]int{1, 2, 3}, 4))
}
