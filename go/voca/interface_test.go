package voca

import (
	"math"
	"testing"

	"github.com/stretchr/testify/assert"
)

type Geometry interface {
	area() float64
	perim() float64
}

type Rectangle struct {
	width, height float64
}

type Circle struct {
	radius float64
}

func (r Rectangle) area() float64 {
	return r.width * r.height
}

func (r Rectangle) perim() float64 {
	return 2*r.width + 2*r.height
}

func (c Circle) area() float64 {
	return math.Pi * c.radius
}

func (c Circle) perim() float64 {
	return 2 * math.Pi * c.radius
}

func area(g Geometry) float64 {
	return g.area()
}

func TestMain(t *testing.T) {
	r := Rectangle{width: 3, height: 4}
	c := Circle{radius: 5}
	assert.Equal(t, float64(12), r.area(), "?")
	assert.Equal(t, float64(15.707963267948966), area(c), "?")
}
