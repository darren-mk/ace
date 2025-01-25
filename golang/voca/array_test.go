package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestIntArray(t *testing.T) {
	var a [3]int
	a[0] = 11
	a[1] = 22
	a[2] = 33
	assert.Equal(t, 11, a[0], "wrong")
	assert.Equal(t, 22, a[1], "wrong")
	assert.Equal(t, 33, a[2], "wrong")
}

func TestBoolArray(t *testing.T) {
	a := [3]bool{true, false, true}
	assert.Equal(t, true, a[0], "no")
	assert.Equal(t, false, a[1], "no")
}
