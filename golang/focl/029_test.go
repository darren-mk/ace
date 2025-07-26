package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

/* Problem 29, Get the Caps
   Difficulty: easy
   Write a function which takes a string and returns
   a new string containing only the capital letters.
   (= (__ "HeLlO, WoRlD!") "HLOWRD")
   (empty? (__ "nothing"))
   (= (__ "$#A(*&987Zf") "AZ") */

const alphabetA = rune('A')
const alphabetZ = rune('Z')

func filterForUppercaseAlphabet(s string) string {
	result := []rune{}
	for _, c := range s {
		if c >= alphabetA && c <= alphabetZ {
			result = append(result, c)
		}
	}
	return string(result)
}

func TestFocl029(t *testing.T) {
	assert.Equal(t, "HLOWRD", filterForUppercaseAlphabet("HeLlO, WoRlD!"))
	assert.Equal(t, "", filterForUppercaseAlphabet("nothing"))
}
