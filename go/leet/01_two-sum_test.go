package gtcp

import (
	"testing"
	"github.com/stretchr/testify/assert"
)

func twoSum(nums []int, target int) []int {
	seen := map[int]int{}
	for i, num := nums {
		y, j :=	seen[num]
		if j {
			return []int{i, j}
		} else {
			seen[num] = i
		}
	}
}

type TestCase struct {
	input  []int
	target int
	answer []int
}

var test_cases = []TestCase{
	{input: []int{2, 7, 11, 15}, target: 9, answer: []int{0, 1}},
	{input: []int{3, 2, 4}, target: 6, answer: []int{1, 2}},
	{input: []int{3, 3}, target: 6, answer: []int{0, 1}}}

func TestCheck(t *testing.T) {
	for _, tc := range test_cases {
		assert.Equal(t, tc.answer, twoSum(tc.input, tc.target))
	}
}
