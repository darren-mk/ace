package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

var m = map[int]string{
	1: "hi",
	2: "bye",
	3: "yo",
}

func TestMap(t *testing.T) {
	assert.Equal(t, 3, len(m), "?")
	assert.Equal(t, "bye", m[2], "?")
	assert.Equal(t, "", m[100], "?")
	delete(m, 2)
	assert.Equal(t, 2, len(m), "?")
	assert.Equal(t, "", m[2], "?")
	clear(m)
	assert.Equal(t, 0, len(m), "?")
}

func TestMapLoop(t *testing.T) {
	for i, v := range m {
		println(i)
		assert.Equal(t, i, i)
		assert.Equal(t, v, v)
	}
}
