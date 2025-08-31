package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 15, Double Down
   Difficulty: elementary
   Write a function which doubles a number.
   (= (__ 2) 4)
   (= (__ 3) 6)
   (= (__ 11) 22)
   (= (__ 7) 14) */

func TestVoca015Check(t *testing.T) {
	f := func(a int) int { return a * 2 }
	assert.Equal(t, 4, f(2))
}
