package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

var m = map[int]string{
	1: "hi",
	2: "bye",
}

func TestMap(t *testing.T) {
	assert.Equal(t, "bye", m[2], "wrong")
}
