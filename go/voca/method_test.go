package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

type Rect struct {
	width, height int
}

func (r *Rect) area() int {
	return r.width * r.height
}

func TestArea(t *testing.T) {
	r := Rect{width: 2, height: 3}
	assert.Equal(t, 6, r.area(), "?")
}

func (r Rect) perimeter() int {
	return 2*r.width + 2*r.height
}

func TestPerimeter(t *testing.T) {
	r := Rect{width: 2, height: 3}
	assert.Equal(t, 10, r.perimeter(), "?")
}
