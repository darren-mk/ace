package wars

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Quadratic(x1, x2 int) [3]int {
	return [3]int{1, -x1 - x2, x1 * x2}
}

func TestAppendWithSlice(t *testing.T) {
	assert.Equal(t, Quadratic(0, 1), [3]int{1, -1, 0})
	assert.Equal(t, Quadratic(4, 9), [3]int{1, -13, 36})
	assert.Equal(t, Quadratic(2, 6), [3]int{1, -8, 12})
	assert.Equal(t, Quadratic(-5, -4), [3]int{1, 9, 20})
}
