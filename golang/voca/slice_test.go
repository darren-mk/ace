package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSlice(t *testing.T) {
	a := [5]int{1, 2, 3, 4, 5}
	b := a[1:4]
	assert.Equal(t, 4, a[3], "wrong")
	assert.Equal(t, 2, b[0], "wrong")
	assert.Equal(t, 3, b[1], "wrong")
}
