package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/*
Problem 1, Nothing but the Truth
Difficulty: elementary
Complete the expression so it will evaluate to true.
(= __ true)
*/

func a(b bool) bool {
	return b == true
}

func TestCheck(t *testing.T) {
	assert.True(t, a(true))
}
