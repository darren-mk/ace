package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* The slice type is an abstraction built on top of Go’s
   array type. Arrays have their place, but they’re a bit
   inflexible, so you don’t see them too often in Go code.
   Slices, though, are everywhere. They build on arrays to
   provide great power and convenience.
   The type specification for a slice is []T, where T is
   the type of the elements of the slice. Unlike an array
   type, a slice type has no specified length.
*/

func TestSliceBasics(t *testing.T) {
	var hits []int
	assert.Equal(t, 0, len(hits))
}

func TestSliceExpressions(t *testing.T) {
	hits := []int{10, 20, 30, 40, 50}
	firstTwo := hits[:2]
	assert.Equal(t, []int{10, 20}, firstTwo)
	assert.Equal(t, 2, len(firstTwo))
	assert.Equal(t, 5, cap(firstTwo))
	assert.Equal(t, []int{40, 50}, hits[len(hits)-2:])
	extended := firstTwo[:5]
	assert.Equal(t, hits, extended)
}

func TestTurnArrayToSlice(t *testing.T) {
	arr := [3]int{1, 2, 3}
	sl := arr[:]
	assert.Equal(t, sl, []int{1, 2, 3})
}

/* A slice can be created with the built-in function called
   make, which has the signature,

   func make([]T, len, cap) []T

   where T stands for the element type of the slice to be
   created. The make function takes a type, a length, and
   an optional capacity. When called, make allocates an
   array and returns a slice that refers to that array.

   var s []byte
   s = make([]byte, 5, 5)
   // s == []byte{0, 0, 0, 0, 0}
   When the capacity argument is omitted, it defaults to
   the specified length. Here’s a more succinct version
   of the same code:
   s := make([]byte, 5)
*/

func TestCreateSliceUsingMake(t *testing.T) {
	sl := make([]byte, 2, 3)
	assert.Equal(t, len(sl), 2)
	assert.Equal(t, cap(sl), 3)
}
