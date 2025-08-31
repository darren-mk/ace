package voca

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

type IntSet map[int]struct{}

func (s IntSet) Add(k int) {
	s[k] = struct{}{}
}

func (s IntSet) Remove(k int) {
	delete(s, k)
}

func (s IntSet) Contains(k int) bool {
	_, exists := s[k]
	return exists
}

func (s IntSet) Size() int {
	return len(s)
}

func TestIntSet(t *testing.T) {
	lucky_nums := IntSet{}
	lucky_nums.Add(1)
	lucky_nums.Add(2)
	lucky_nums.Add(3)
	assert.Equal(t, 3, lucky_nums.Size(), "wrong")
	assert.True(t, lucky_nums.Contains(2), "wrong")
	assert.False(t, lucky_nums.Contains(4), "wrong")
	lucky_nums.Remove(2)
	assert.False(t, lucky_nums.Contains(2), "wrong")
}

type GenericSet[T comparable] map[T]struct{}

func (gs GenericSet[T]) Add(k T) {
	gs[k] = struct{}{}
}

func (gs GenericSet[T]) Remove(k T) {
	delete(gs, k)
}

func (gs GenericSet[T]) Size() int {
	return len(gs)
}

func (gs GenericSet[T]) Contains(k T) bool {
	_, exists := gs[k]
	return exists
}

func TestGenericSet(t *testing.T) {
	names := GenericSet[string]{}
	names.Add("darren")
	names.Add("minsoo")
	names.Add("kim")
	assert.Equal(t, 3, names.Size(), "wrong")
	assert.True(t, names.Contains("darren"), "wrong")
	assert.False(t, names.Contains("micky"), "wrong")
	names.Remove("darren")
	assert.False(t, names.Contains("darren"), "wrong")
}
