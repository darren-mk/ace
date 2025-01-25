package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLen(t *testing.T) {
	a := [5]int{1, 2, 3}
	assert.Equal(t, 5, len(a), "no")
}
