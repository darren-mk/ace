from dataclasses import dataclass

@dataclass
class Point:
    x: int
    y: int

def test_basic():
    p = Point(2, 3)
    assert p.x == 2
    assert p.y == 3

@dataclass(frozen=True)
class Animal:
    name: str
    age: int

def test_immutable():
    a = Animal('mira', 2)
    assert a.name == 'mira'
    # a.age = 3 # error

@dataclass(order=True)
class Task:
    id: int
    description: str

def test_ordered():
    t1 = Task(1, "grocery")
    t2 = Task(2, "exercise")
    assert t1 < t2
