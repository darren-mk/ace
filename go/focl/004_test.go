package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/*
Problem 4, Lists
Difficulty: elementary
Lists can be constructed with either a function or a quoted form.
(= (list __) '(:a :b :c))
*/

func voca004A() []int {
	a := make([]int, 3)
	a[0], a[1], a[2] = 1, 2, 3
	return a
}

func TestVoca004Check(t *testing.T) {
	assert.Equal(t, []int{1, 2, 3}, voca004A(), "no")
}
