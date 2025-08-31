package voca

import (
	"maps"
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 11, conj on maps
   Difficulty: elementary
   When operating on a map, the conj function returns
   a new map with one or more key-value pairs "added".
   (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3])) */

func merge2maps(a map[string]int, b map[string]int) map[string]int {
	for k, v := range b {
		a[k] = v
	}
	return a
}

func TestVoca011Check(t *testing.T) {
	x := map[string]int{"a": 1, "b": 2}
	y := map[string]int{"b": 10, "c": 3}
	z := map[string]int{"d": 4}
	merge2maps(x, y)
	valX, okX := x["c"]
	assert.Equal(t, 3, valX)
	assert.True(t, okX)
	maps.Copy(y, z)
	valY, okY := y["d"]
	assert.Equal(t, 4, valY)
	assert.True(t, okY)
}
