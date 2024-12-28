def acc = 0
[1, 2, 3].each { it -> acc += it }
assert acc == 6

def m = ['a': 1, 'b': 2]
m.each { k, v -> m[k] = v * 10 }
assert m == ['a': 10, 'b': 20]
