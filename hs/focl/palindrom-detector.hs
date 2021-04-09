
-- 1
f1 l = (l == (reverse l))
f1 [1, 2, 3, 4, 5] -- False
f1 [1, 1, 3, 3, 1, 1] -- True
f1 ['a', 'b', 'c'] -- False
