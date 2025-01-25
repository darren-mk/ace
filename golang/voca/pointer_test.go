package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

var p *int

func TestPointingAndDenoting(t *testing.T) {
	i := 23
	p = &i
	assert.Equal(t, i, *p, "wrong")
}
