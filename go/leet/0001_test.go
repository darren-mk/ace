package leet

import (
	"testing"
	"github.com/stretchr/testify/assert"
)

func twoSumA(nums []int, target int) []int {
	valToInd := map[int]int {}
	for i, x := range nums {
		if j, ok := valToInd[target-x]; ok {
			return []int{j, i} }
		valToInd[x] = i }
	return []int{} }

func TestTwoSumA(t *testing.T) {
	assert.Equal(t, []int{0,1}, twoSumA([]int{2,7,11,15}, 9))
	assert.Equal(t, []int{1,2}, twoSumA([]int{3,2,4}, 6))
	assert.Equal(t, []int{0,1}, twoSumA([]int{3,3}, 6)) }

/*
Runtime 100.00%
Memory 40.75%
*/