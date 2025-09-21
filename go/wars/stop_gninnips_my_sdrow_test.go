package wars

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

func reverseString(s string) string {
	rs := []rune(s)
	n := len(rs)
	// out := make([]rune, n)
	out := [n]rune
	for i := range n {
		out[n-i-1] = rs[i]
	}
	return string(out)
}

func SpinWords(str string) string {
	words := strings.Split(str, " ")
	newItems := []string{}
	for _, item := range words {
		var newItem string
		if len(item) >= 5 {
			newItem = reverseString(item)
		} else {
			newItem = item
		}
		newItems = append(newItems, newItem)
	}
	return strings.Join(newItems, " ")
}

func TestSpinWords(t *testing.T) {
	assert.Equal(t, []string{"abc", "def"}, strings.Split("abc def", " "))
	assert.Equal(t, "cba", reverseString("abc"))
	assert.Equal(t, "emocleW", SpinWords("Welcome"))
	assert.Equal(t, "to", SpinWords("to"))
	assert.Equal(t, "CodeWars", SpinWords("sraWedoC"))
	assert.Equal(t, "Hey wollef sroirraw", SpinWords("Hey fellow warriors"))
	assert.Equal(t, "sregruB are my etirovaf tiurf", SpinWords("Burgers are my favorite fruit"))
	assert.Equal(t, "azziP is the best elbategev", SpinWords("Pizza is the best vegetable"))
}
