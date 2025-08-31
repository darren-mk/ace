package gtcp

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func n3(arr []int) int {
	best := 0
	size := len(arr)
	for a := range size {
		for b := a; b < size; b++ {
			sum := 0
			for i := a; i <= b; i++ {
				sum += arr[i]
			}
			best = max(best, sum)
		}
	}
	return max(best, arr[0])
}

func n2(arr []int) int {
	best := 0
	size := len(arr)
	for a := range size {
		sum := 0
		for i := a; i < size; i++ {
			sum += arr[i]
			best = max(best, sum)
		}
	}
	return best
}

func n1(arr []int) int {
	best := 0
	size := len(arr)
	sum := 0
	for i := range size {
		sum = max(sum+arr[i], arr[i])
		best = max(best, sum)
	}
	return best
}

func TestCheck(t *testing.T) {
	assert.Equal(t, 10, n3([]int{-1, 2, 4, -3, 5, 2, -5, 2}))
	assert.Equal(t, 10, n2([]int{-1, 2, 4, -3, 5, 2, -5, 2}))
	assert.Equal(t, 10, n1([]int{-1, 2, 4, -3, 5, 2, -5, 2}))
}
