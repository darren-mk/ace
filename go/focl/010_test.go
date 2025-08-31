package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 10, Maps
   Difficulty: elementary
   Maps store key-value pairs. Both maps and keywords
   can be used as lookup functions. Commas are whitespace.
   (= __ ((hash-map :a 10, :b 20, :c 30) :b))
   (= __ (:b {:a 10, :b 20, :c 30})) */

func TestVoca010Check(t *testing.T) {
	m := map[string]int{"abc": 1}
	elemAbcVal, elemAbcOk := m["abc"]
	assert.Equal(t, 1, elemAbcVal)
	assert.Equal(t, true, elemAbcOk)
	elemXyzVal, elemXyzOk := m["xyz"]
	assert.Equal(t, 0, elemXyzVal)
	assert.Equal(t, false, elemXyzOk)
}
