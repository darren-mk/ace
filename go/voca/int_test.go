package voca

import (
	"testing"
	"unsafe"

	"github.com/stretchr/testify/assert"
)

func TestIntBasics(t *testing.T) {
	/* The numbers 4 and 8 are the size in bytes
	   of the int type on your system.
	   4 bytes = 32 bits (int is 32-bit wide).
	   8 bytes = 64 bits (int is 64-bit wide). */
	var i int
	assert.Equal(t, 8, int(unsafe.Sizeof(i)))
}
