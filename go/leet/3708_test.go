package leet

import (
	"testing"
	"github.com/stretchr/testify/assert" )

func longestSubarray(nums []int) int {
	return 1 }

func TestLongestSubarray(t *testing.T) {
	assert.Equal(t, 5, longestSubarray([]int{1,1,1,1,2,3,5,1}))
	assert.Equal(t, 5, longestSubarray([]int{5,2,7,9,16}))
	assert.Equal(t, 2, longestSubarray([]int{1000000000,1000000000,1000000000})) }