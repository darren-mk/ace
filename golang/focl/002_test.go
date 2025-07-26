package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/*
Problem 2, Simple Math
Difficulty: elementary
Innermost forms are evaluated first.
   (= (- 10 (* 2 3)) __)
*/

func voca002A() int {
	return -10 + (2 * 3)
}

func TestVoca002Check(t *testing.T) {
	assert.Equal(t, -4, voca002A(), "wrong")
}
