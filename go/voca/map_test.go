package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMap(t *testing.T) {
	m := map[int]string{
		1: "hi",
		2: "bye",
		3: "yo",
	}
	assert.Equal(t, 3, len(m), "?")
	assert.Equal(t, "bye", m[2], "?")
	assert.Equal(t, "", m[100], "?")
	delete(m, 2)
	assert.Equal(t, 2, len(m), "?")
	assert.Equal(t, "", m[2], "?")
	clear(m)
	assert.Equal(t, 0, len(m), "?")
}
