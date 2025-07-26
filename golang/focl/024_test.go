package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 24, Sum It All Up
   Difficulty: easy
   Write a function which returns the sum of a sequence of numbers.
   (= (__ [1 2 3]) 6)
   (= (__ (list 0 -2 5 5)) 8)
   (= (__ #{4 2 1}) 7)
   (= (__ '(0 0 -1)) -1)
   (= (__ '(1 10 3)) 14) */

func sumItAllUp(nums ...int) int {
	result := 0
	for _, num := range nums {
		result = result + num
	}
	return result
}

func TestVoca024Check(t *testing.T) {
	assert.Equal(t, 6, sumItAllUp(1, 2, 3))
}
