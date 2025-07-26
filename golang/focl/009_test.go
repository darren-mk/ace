package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 9, conj on sets
   Difficulty: elementary
   When operating on a set, the conj function returns
   a new set with one or more keys "added".
   (= #{1 2 3 4} (conj #{1 4 3} __)) */

func TestVoca009Check(t *testing.T) {
	st := map[int]struct{}{}
	st[1] = struct{}{}
	st[2] = struct{}{}
	_, does1exist := st[1]
	assert.True(t, does1exist)
}
