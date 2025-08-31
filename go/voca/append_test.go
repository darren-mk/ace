package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestAppendWithSlice(t *testing.T) {
	arr := []int{1, 2, 3}
	assert.Equal(t, []int{1, 2, 3, 4}, append(arr, 4), "?")
}
