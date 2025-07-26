package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 19, Last Element
   Difficulty: easy
   Write a function which returns the last element in a sequence.
   (= (__ [1 2 3 4 5]) 5)
   (= (__ '(5 4 3)) 3)
   (= (__ ["b" "c" "d"]) "d") */

func lastElem[T any](coll []T) T {
	return coll[len(coll)-1]
}

func TestVoca019Check(t *testing.T) {
	assert.Equal(t, 3, lastElem([]int{1, 2, 3}))
}
