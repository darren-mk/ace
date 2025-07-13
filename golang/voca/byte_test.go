package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestHowExpressByteType(t *testing.T) {
	var a byte
	a = 12
	assert.Equal(t, byte(12), a, "?")
}
