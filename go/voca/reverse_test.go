package voca

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

func reverseArray[T comparable](items []T) []T {
	new := []T{}
	for i := len(items) - 1; i >= 0; i-- {
		new = append(new, items[i])
	}
	return new
}

func TestReverseArray(t *testing.T) {
	assert.Equal(t, []string{"abc", "def"}, strings.Split("abc def", " "))
	assert.Equal(t, []string{"abc", "def"}, strings.Split("abc def", " "))
	assert.Equal(t, []int{3, 2, 1}, reverseArray([]int{1, 2, 3}))
}

func reverseString(s string) string {
	rs := []rune(s)
	new := []rune{}
	for i := len(rs) - 1; i >= 0; i-- {
		new = append(new, rs[i])
	}
	return string(new)
}

func TestReverseString(t *testing.T) {
	assert.Equal(t, 1, 1)
	assert.Equal(t, "anuL", reverseString("Luna"))
}
