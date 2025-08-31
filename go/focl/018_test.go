package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 18, filter
   Difficulty: elementary
   The filter function takes two arguments:
   a predicate function (f) and a sequence (s).
   Filter returns a new sequence consisting of all
   the items of s for which (f item) returns true.
   (= __ (filter #(> % 5) '(3 4 5 6 7)))
*/

func TestVoca018Check(t *testing.T) {
	filterF := func(f func(int) bool, coll []int) []int {
		var result []int
		for _, x := range coll {
			if f(x) {
				result = append(result, x)
			}
		}
		return result
	}
	isSmallerThan4 := func(x int) bool { return x < 4 }
	assert.Equal(t, []int{1, 2, 3}, filterF(isSmallerThan4, []int{1, 2, 3, 4, 5}))
}
