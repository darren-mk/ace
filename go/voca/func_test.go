package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Add(a, b int) int {
	return a + b
}

func TestAdd(t *testing.T) {
	result := Add(2, 3)
	assert.Equal(t, 5, result, "they should be equal")
}

func runTwice(v int, f func(int) int) int {
	return f(f(v))
}

func addOne(v int) int {
	return v + 1
}

func TestPassingFunction(t *testing.T) {
	assert.Equal(t, 12, runTwice(10, addOne))
}

func makeDynamicAdder(i int) func(int) int {
	return func(x int) int { return x + i }
}

func TestClosureBasics(t *testing.T) {
	f := makeDynamicAdder(7)
	assert.Equal(t, 17, f(10))
}
