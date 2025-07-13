package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestSliceBasics(t *testing.T) {
	var hits []int
	assert.Equal(t, 0, len(hits), "?")
}

func TestSliceExpressions(t *testing.T) {
	hits := []int{10, 20, 30, 40, 50}
	firstTwo := hits[:2]
	assert.Equal(t, []int{10, 20}, firstTwo, "?")
	assert.Equal(t, 2, len(firstTwo), "?")
	assert.Equal(t, 5, cap(firstTwo), "?")
	assert.Equal(t, []int{40, 50}, hits[len(hits)-2:], "?")
	extended := firstTwo[:5]
	assert.Equal(t, hits, extended, "?")
}
