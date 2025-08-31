package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 8, Sets
   Difficulty: elementary
   Sets are collections of unique values.
   (= __ (set '(:a :a :b :c :c :c :c :d :d)))
   (= __ (clojure.set/union #{:a :b :c} #{:b :c :d})) */

func sliceToSet(items []int) map[int]struct{} {
	set := make(map[int]struct{})
	for _, item := range items {
		set[item] = struct{}{}
	}
	return set
}

func TestVoca008Check(t *testing.T) {
	set := sliceToSet([]int{1, 1, 3, 2, 2, 1, 3})
	_, does1exist := set[1]
	_, does4exist := set[4]
	assert.True(t, does1exist)
	assert.False(t, does4exist)
}
