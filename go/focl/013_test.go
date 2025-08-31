package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 13, rest
   Difficulty: elementary
   The rest function will return all the
   items of a sequence except the first.
   (= __ (rest [10 20 30 40])) */

func TestVoca013Check(t *testing.T) {
	slc := []string{"a", "b", "c"}
	assert.Equal(t, []string{"b", "c"}, slc[1:])
}
