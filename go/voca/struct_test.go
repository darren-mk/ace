package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

type Vertex struct {
	X int
	Y int
}

func TestCreatingStruct(t *testing.T) {
	here := Vertex{1, 2}
	assert.Equal(t, 1, here.X, "wrong")
	assert.Equal(t, 2, here.Y, "wrong")
}

func TestPointingToStruct(t *testing.T) {
	there := Vertex{1, 2}
	struct_p := &there
	assert.Equal(t, 1, struct_p.X, "wrong")
	assert.Equal(t, 2, struct_p.Y, "wrong")
}

func TestUsingFieldInCreatingStruct(t *testing.T) {
	somewhere := Vertex{X: 1}
	assert.Equal(t, 1, somewhere.X, "wrong")
	assert.Equal(t, 0, somewhere.Y, "wrong")
}

type person struct {
	name string
	age  int
}

func TestNewPerson(t *testing.T) {
	p := person{name: "darren"}
	p.age = 88
	assert.Equal(t, "darren", p.name, "?")
	assert.Equal(t, 88, p.age, "?")
}
