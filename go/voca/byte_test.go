package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestHowExpressByteType(t *testing.T) {
	/* byte is an alias for uint8 (an unsigned 8-bit integer) */
	var a byte = 12
	var b uint8 = 12
	assert.Equal(t, byte(12), a, "?")
	assert.Equal(t, a, b)
}
