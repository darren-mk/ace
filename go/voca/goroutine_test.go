package voca

import (
	"testing"
	"time"

	"github.com/stretchr/testify/assert"
)

func TestGoroutineBasics(t *testing.T) {

	t.Logf("start!")
	t.Logf(time.Now().String())

	breatheAndSay := func(s string) {
		time.Sleep(1 * time.Second)
		t.Logf(time.Now().String() + s)
	}

	go breatheAndSay("one")
	go breatheAndSay("two")
	go breatheAndSay("three")
	breatheAndSay("four")
	assert.True(t, true)
}
