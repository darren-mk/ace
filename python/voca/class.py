class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

def test_construction():
    me = Person('Darren', 100)
    assert me.name == 'Darren'
    you = me
    you.age = 50
    assert me.age == 50