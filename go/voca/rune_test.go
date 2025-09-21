package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestRuneBasics(t *testing.T) {
	/* rune is an alias for int32 (a signed 32-bit integer) */
	var a int32 = 12
	var b rune = 12
	assert.Equal(t, a, b)
}

func TestRuneCollection(t *testing.T) {
	s := "yay"
	r := []rune(s)
	assert.Equal(t, []rune{'y', 'a', 'y'}, r)
}
