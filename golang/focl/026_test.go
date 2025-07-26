package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 26, Fibonacci Sequence
   Difficulty: easy
   Write a function which returns the first X fibonacci numbers.
   (= (__ 3) '(1 1 2))
   (= (__ 6) '(1 1 2 3 5 8))
   (= (__ 8) '(1 1 2 3 5 8 13 21)) */

var mem = map[int]int{0: 1, 1: 1}

func fib(n int) int {
	if v, ok := mem[n]; ok {
		return v
	}
	calc := fib(n-2) + fib(n-1)
	mem[n] = calc
	return calc
}

func fibSeq(n int) []int {
	result := []int{}
	for i := range n {
		result = append(result, fib(i))
	}
	return result
}

func TestVoca026Check(t *testing.T) {
	assert.Equal(t, 1, fib(0))
	assert.Equal(t, 1, fib(1))
	assert.Equal(t, []int{1, 1, 2, 3, 5, 8, 13, 21}, fibSeq(8))
}
