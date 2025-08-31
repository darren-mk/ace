package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 25, Find the odd numbers
   Difficulty: easy
   Write a function which returns only
   the odd numbers from a sequence.
   (= (__ #{1 2 3 4 5}) '(1 3 5))
   (= (__ [4 2 1 6]) '(1))
   (= (__ [2 2 4 6]) '())
   (= (__ [1 1 1 3]) '(1 1 1 3)) */

func isOddNumer(x int) bool {
	return x%2 == 1
}

func filter[T any](pred func(T) bool, coll []T) []T {
	result := []T{}
	for _, v := range coll {
		if pred(v) {
			result = append(result, v)
		}
	}
	return result
}

func TestVoca025Check(t *testing.T) {
	assert.True(t, isOddNumer(3))
	assert.False(t, isOddNumer(2))
	assert.Equal(t, []int{1, 3, 5}, filter(isOddNumer, []int{1, 2, 3, 4, 5}))
}
