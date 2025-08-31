package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Go’s arrays are values.
   An array variable denotes the entire array;
   it is not a pointer to the first array element
   (as would be the case in C). This means that
   when you assign or pass around an array value
   you will make a copy of its contents.
   (To avoid the copy you could pass a pointer
   to the array, but then that’s a pointer to an
   array, not an array.) One way to think about
   arrays is as a sort of struct but with indexed
   rather than named fields:
   a fixed-size composite value.
*/

func TestCreateEmptyArray(t *testing.T) {
	var a [3]int
	a[0] = 1
	a[1] = 2
	a[2] = 3
	assert.Equal(t, 1, a[0])
	assert.Equal(t, 2, a[1])
	assert.Equal(t, 3, a[2])
	assert.Equal(t, [3]int{1, 2, 3}, a)
}

func TestBoolArray(t *testing.T) {
	a := [3]bool{true, false, true}
	assert.Equal(t, true, a[0], "no")
	assert.Equal(t, false, a[1], "no")
}

func sum(a [3]int) int {
	return a[0] + a[1] + a[2]
}

func TestPassArrayToFn(t *testing.T) {
	a := [3]int{1, 2, 3}
	assert.Equal(t, 6, sum(a), "?")
}

func TestRemindBasics(t *testing.T) {
	a := []byte{10, 2, 1}
	b := []byte{10, 2, 1}
	t.Logf("a: %p, b: %p", &a[0], &b[0])
	assert.Equal(t, a, b, "no")
}

func TestArraySliceNotEqual(t *testing.T) {
	assert.NotEqual(t, []int{1}, [1]int{1}, "no")
	/* one is a slice ([]int) and the other is an
	   array ([1]int), and Go treats these as
	   completely different types, even if their
	   contents look identical. */
}
