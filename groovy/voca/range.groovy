def x = 1..10
assert x[0] == 1
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert x.contains(1)
assert x.contains(10)
assert !x.contains(11)
assert ('a'..'d').contains('b')
