package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 12, Sequences
   Difficulty: elementary
   All Clojure collections support sequencing.
   You can operate on sequences with functions
   like first, second, and last.
   (= __ (first '(3 2 1)))
   (= __ (second [2 3 4]))
   (= __ (last (list 1 2 3))) */

func TestVoca012Check(t *testing.T) {
	slc := []string{"a", "b", "c"}
	assert.Equal(t, "a", slc[0])
	assert.Equal(t, "b", slc[1])
	assert.Equal(t, "c", slc[len(slc)-1])
}
