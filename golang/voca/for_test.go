package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func for_basic() int {
	sum := 0
	for i := 0; i < 5; i++ {
		sum += i
	}
	return sum
}

func TestFor(t *testing.T) {
	assert.Equal(t, 10, for_basic(), "wrong")
}
