package leet

import (
    "testing"
    "github.com/stretchr/testify/assert"
    "strings" )

func numOfStrings(patterns []string, word string) int {
	count := 0
	for _, pattern := range patterns {
		if strings.Contains(word, pattern) {
			count++ } }
	return count }

func TestNumOfStrings(t *testing.T) {
    assert.True(t, strings.Contains("abc", "bc"))
    assert.False(t, strings.Contains("abc", "d"))
    assert.Equal(t, 3, numOfStrings([]string{"a", "abc", "bc", "d"}, "abc"))
    assert.Equal(t, 2, numOfStrings([]string{"a","b","c"}, "aaaaabbbbb"))
    assert.Equal(t, 3, numOfStrings([]string{"a","a","a"}, "ab")) }