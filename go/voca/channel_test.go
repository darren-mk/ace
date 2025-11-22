package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func f(t *testing.T, msg string, channel chan string) {
	t.Logf("f is called with " + msg)
	channel <- msg }

func TestChannelBasics(t *testing.T) {
	c := make(chan string)
	go f(t, "yo", c)
	go f(t, "bro", c)
	x, y := <-c, <-c
	assert.True(t, x == "yo" || x == "bro")
	assert.True(t, y == "yo" || y == "bro") }

func TestBufferedChannels(t *testing.T) {
	ch := make(chan string, 3)
	for i := 0; i < 3; i++ {
		go f(t, "hey", ch) }
	assert.Equal(t, "hey", <-ch)
	assert.Equal(t, "hey", <-ch)
	assert.Equal(t, "hey", <-ch) }