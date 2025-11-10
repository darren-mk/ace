class StaticPerson:
    category = 'Human'

def test_static_attribute():
    assert StaticPerson.category == 'Human'
    p = StaticPerson()
    assert p.category == 'Human'

class Animal:
    def __init__(self, weight):
        self.weight = weight

def test_class_init_default():
    dog = Animal(30)
    assert dog.weight == 30

class Person(Animal):
    def __init__(self, name, age, weight):
        self.name = name
        self.age = age
        super().__init__(weight)
    def greet(self):
        return f"This is {self.name}."

def test_class_inheritance():
    me = Person('Darren', 100, 150)
    assert me.name == 'Darren'
    assert me.age == 100
    assert me.weight == 150
    assert me.greet() == "This is Darren."

class Calculator:
    def add(_self, a, b):
        return a + b
    def multiply(_, a, b):
        return a * b

def test_class_methods():
    calc = Calculator()
    assert calc.add(2, 3) == 5
    assert calc.multiply(4, 5) == 20

def test_class_deletion():
    calc = Calculator()
    assert calc.add(2, 3) == 5
    del calc
    try:
        calc.add(2, 3)
        assert False, "Expected an exception after deletion"
    except NameError:
        assert True

class User:
    def __init__(self, username, password):
        self.username = username
        self.__password = password  # private attribute
    def check_password(self, password_to_check):
        return self.__password == password_to_check
    
def test_class_private_property():
    user = User('jack123', 'secretpassword')
    assert user.username == 'jack123'
    assert user.check_password('secretpassword') is True
    assert user.check_password('wrongpassword') is False