package voca

import (
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

type geometry interface {
	area() float64
	perim() float64
}

type rectangle struct {
	width, height float64
}

type circle struct {
	radius float64
}

func (r rectangle) area() float64 {
	return r.width * r.height
}

func (r rectangle) perim() float64 {
	return 2*r.width + 2*r.height
}

func (c circle) area() float64 {
	return math.Pi * c.radius
}

func (c circle) perim() float64 {
	return 2 * math.Pi * c.radius
}

func area(g geometry) float64 {
	return g.area()
}

func TestMain(t *testing.T) {
	r := rectangle{width: 3, height: 4}
	c := circle{radius: 5}
	assert.Equal(t, float64(12), area(r), "?")
	assert.Equal(t, float64(15.707963267948966), area(c), "?")
}
