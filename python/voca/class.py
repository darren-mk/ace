class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

darren = Person('Darren', 100)
# <__main__.Person object at 0x10703fac0>
id(darren)
# 4412668608
kim = darren
kim.age = 70
# darren.age # 70
# class object does reference copy

me = {'name': 'Darren',
      'age': 100}
# {'name': 'Darren', 'age': 100}
# id(me) #4412665472
me_too = me
me_too['age'] = 50
# me['age'] # 50
# dictionary copies by reference too

num = 7
num_too = num
num_too = 3
# num # 7
# primitive is by value

dog = {'name': 'happy'}
dog_else = dog.copy()
dog_else['name'] = 'sad'
dog['name'] # happy
# using copy(), copies by value
