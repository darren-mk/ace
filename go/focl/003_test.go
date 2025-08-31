package voca

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

/*
Problem 3, Strings
Difficulty: elementary
Clojure strings are Java strings, so you can use Java string methods on them.
(= __ (.toUpperCase "hello world"))
*/

func voca003A(s string) string {
	return strings.ToUpper(s)
}

func TestVoca003Check(t *testing.T) {
	assert.Equal(t, "HELLO WORLD", voca003A("hello world"), "wrong")
}
