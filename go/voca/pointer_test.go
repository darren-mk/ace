package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

var p *int

func TestPointingAndDenoting(t *testing.T) {
	i := 23
	p = &i
	assert.Equal(t, i, *p, "wrong")
}

func TestPointerBasics(t *testing.T) {
	counter := 42
	pointer := &counter
	assert.Equal(t, 42, *pointer, "?")
}

func incrPointer(c *int) {
	*c++
}

func TestPassByValAndByPointer(t *testing.T) {
	counter := 1
	assert.Equal(t, 1, counter, "wrong")
	incrPointer(&counter)
	assert.Equal(t, 2, counter, "wrong")
}

func TestStartingEmpty(t *testing.T) {
	var ptr *int
	assert.True(t, nil == ptr, "?")
	num := 12
	ptr = &num
	assert.True(t, nil != ptr, "?")
	assert.Equal(t, num, *ptr, "?")
}
