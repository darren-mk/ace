package leet

import (
	"testing"
	"github.com/stretchr/testify/assert" )

var memo = make(map[int]int)

func fib(x int) int {
    if x <= 1 {
        return x }
    v, ok := memo[x]
    if ok {
        return v }
    memo[x] = fib(x - 1) + fib(x - 2)
    return memo[x] }

func TestFib(t *testing.T) {
	assert.Equal(t, 0, fib(0))
    assert.Equal(t, 1, fib(1))
    assert.Equal(t, 1, fib(2))
    assert.Equal(t, 5, fib(5))
    assert.Equal(t, 55, fib(10)) }

/*
Runtime Beats 81.57%
Memory Beats 28.30%
*/