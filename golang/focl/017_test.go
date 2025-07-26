package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 17, map
   Difficulty: elementary
   The map function takes two arguments: a function (f)
   and a sequence (s). Map returns a new sequence consisting
   of the result of applying f to each item of s. Do not
   confuse the map function with the map data structure.
   (= __ (map #(+ % 5) '(1 2 3))) */

func TestVoca017Check(t *testing.T) {
	mapf := func(f func(int) int, coll []int) []int {
		var result []int
		for _, x := range coll {
			result = append(result, f(x))
		}
		return result
	}
	inc := func(x int) int { return x + 1 }
	assert.Equal(t, []int{2, 3, 4}, mapf(inc, []int{1, 2, 3}))
}
