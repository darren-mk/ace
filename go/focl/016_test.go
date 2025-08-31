package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 16, Hello World
   Difficulty: elementary
   Write a function which returns a personalized greeting.
   (= (__ "Dave") "Hello, Dave!")
   (= (__ "Jenn") "Hello, Jenn!")
   (= (__ "Rhea") "Hello, Rhea!") */

func TestVoca016Check(t *testing.T) {
	f := func(s string) string { return "Hello, " + s + "!" }
	assert.Equal(t, "Hello, Dave!", f("Dave"))
}
