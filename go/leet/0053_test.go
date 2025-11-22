package leet

import (
	"testing"
	"github.com/stretchr/testify/assert" )

func f0053(nums []int) int {
	best := nums[0]
	cur := nums[0]
	for _, v := range nums[1:] {
		cur = max(v, cur + v)
		best = max(best, cur) }
	return best }

func Test0053(t *testing.T) {
	assert.Equal(t, 6, f0053([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
	assert.Equal(t, 1, f0053([]int{1}))
	assert.Equal(t, 23, f0053([]int{5, 4, -1, 7, 8}))
	assert.Equal(t, -1, f0053([]int{-1})) }