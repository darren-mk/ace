# https://www.learnpython.org/en/Variables_and_Types

# Python is completely object oriented,
# and not "statically typed".
# You do not need to declare variables or their type.
# Every variable in Python is an object.

# Python supports two types of numbers -
# integers(whole numbers) and floating point numbers(decimals).
# (It also supports complex numbers, which will not be explained in this).

# integer
myint = 7
print(myint)
# print() is polymorphic being able to take types including string and integer.

# float
myfloat1 = 7.0
print(myfloat1)
myfloat2 = float(7)
print(myfloat2)
# float() is a function that takes integer and returns float.

# string
# Strings are defined either with a single quote or a double quotes.
mystring1 = 'hello'
print(mystring1)
mystring2 = "hello"
print(mystring2)
# The difference between the two is that using double quotes makes it easy
# to include apostrophes (whereas these would terminate the string if using single quotes)
mystring_with_apo_1 = "Don't worry"
print(mystring_with_apo_1)
mystring_with_apo_2 = 'Don\'t worry'
print(mystring_with_apo_2)

# assignment
# Assignments can be done on more than one variable
# simultaneously on the same line like this
a, b = 3, 4
print(a, b)
# print can take multiple args.

# check type
isinstance(myfloat1, float) # True
isinstance('hello', str)
