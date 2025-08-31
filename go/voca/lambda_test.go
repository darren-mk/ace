package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func addHundred(x int) int {
	return x + 100
}

func passCalculate(x int, f func(int) int) int {
	return f(x)
}

func TestLambda(t *testing.T) {
	assert.Equal(t, passCalculate(7, addHundred), 107, "wrong")
}
