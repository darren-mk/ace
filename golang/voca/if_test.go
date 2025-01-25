package voca

import (
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

func if_basic(x float64) string {
	if v := math.Pow(x, 3); v < 20 {
		return "yo"
	} else if v < 100 {
		return "ma"
	} else {
		return "hi"
	}
}

func TestIf(t *testing.T) {
	assert.Equal(t, "yo", if_basic(2.3), "wrong")
	assert.Equal(t, "ma", if_basic(4.1), "wrong")
	assert.Equal(t, "hi", if_basic(9.3), "wrong")
}
