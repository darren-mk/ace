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

func countElems[T any](coll []T) int {
	n := 0
	for range coll {
		n = n + 1
	}
	return n
}

func TestVoca022Check(t *testing.T) {
	assert.Equal(t, 3, countElems([]int{1, 2, 3}))
}
