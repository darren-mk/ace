package voca

import (
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

func switch_basic(x int) string {
	switch x {
	case 1:
		return "yo"
	case 2:
		return "ha"
	case 3:
		return "ho"
	default:
		return "na"
	}
}

func switch_expanded(x float64) string {
	switch pow := math.Pow(x, 2.0); pow {
	case 1.0:
		return "yo"
	case 4.0:
		return "hi"
	default:
		return "na"
	}
}

func TestSwitch(t *testing.T) {
	assert.Equal(t, "yo", switch_basic(1), "wrong")
	assert.Equal(t, "na", switch_basic(100), "wrong")
	assert.Equal(t, "yo", switch_expanded(1.0), "wrong")
	assert.Equal(t, "hi", switch_expanded(2.0), "wrong")
}
