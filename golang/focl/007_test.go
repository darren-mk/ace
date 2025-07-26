package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 7, conj on vectors
   Difficulty: elementary
   When operating on a Vector, the conj function will return
   a new vector with one or more items "added" to the end.
   (= __ (conj [1 2 3] 4))
   (= __ (conj [1 2] 3 4)) */

func TestVoca007Check(t *testing.T) {
	a := []int{1, 2, 3}
	assert.Equal(t, []int{1, 2, 3, 4}, append(a, 4))
}
