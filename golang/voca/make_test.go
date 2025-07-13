package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMakingSlice(t *testing.T) {
	a := make([]int, 0, 3)
	target_cap := 0
	for i := 0; i < 5; i++ {
		a = append(a, i)
		if i < 3 {
			target_cap = 3
		} else {
			target_cap = 6
		}
		assert.Equal(t, i+1, len(a), "no")
		assert.Equal(t, target_cap, cap(a), "no")
	}
}
