package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestRangeOfSlice(t *testing.T) {
	nums := []int{10, 20, 30, 40, 50}
	for i, v := range nums {
		assert.Equal(t, nums[i], v, "?")
	}
}
