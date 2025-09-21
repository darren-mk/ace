package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestStringBasics(t *testing.T) {
	assert.Equal(t, "123", string([]rune{'1', '2', '3'}))
}
