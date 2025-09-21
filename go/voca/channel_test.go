package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func f(t *testing.T, msg string, channel chan string) {
	t.Logf("f is called with " + msg)
	channel <- msg
}

func TestChannelBasics(t *testing.T) {

	c := make(chan string)

	go f(t, "yo", c)
	go f(t, "bro", c)

	x, y := <-c, <-c

	assert.True(t, "yo" == x || "bro" == x)
	assert.True(t, "yo" == y || "bro" == y)
}

func TestBufferedChannels(t *testing.T) {
	ch := make(chan string, 3)
	for range 3 {
		go f(t, "hey", ch)
	}
	assert.Equal(t, "hey", <-ch)
	assert.Equal(t, "hey", <-ch)
	assert.Equal(t, "hey", <-ch)
}
