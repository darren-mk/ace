package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 14, Functions
   Difficulty: elementary
   Clojure has many different ways to create functions.
   (= __ ((fn add-five [x] (+ x 5)) 3))
   (= __ ((fn [x] (+ x 5)) 3))
   (= __ (#(+ % 5) 3))
   (= __ ((partial + 5) 3)) */

func TestVoca014Check(t *testing.T) {
	f := func(a int) int { return a + 100 }
	assert.Equal(t, 101, f(1))
}
