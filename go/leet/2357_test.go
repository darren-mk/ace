package leet

import (
	"sort"
	"testing"
	"github.com/stretchr/testify/assert" )

func minimumOperations(nums []int) int {
	sort.Ints(nums)
	count := 0
	prev := 0
	for _, num := range nums {
		if num != 0 && num != prev {
			count++ }
		prev = num }
	return count }

func TestMinimumOperations(t *testing.T) {
	assert.Equal(t, 3, minimumOperations([]int{1,5,0,3,5}))
    assert.Equal(t, 0, minimumOperations([]int{0})) }

/*
Runtime Beats 100.00%
Memory Beats 51.47%
*/