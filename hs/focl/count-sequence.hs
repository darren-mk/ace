-- https://www.4clojure.com/problem/22

-- 1
f1 :: Foldable t => t a -> Int
f1 = lenth
(f1 [1, 2, 3, 3, 1]) == 5 -- True
(f1 "Hello World") == 11 -- True
(f1 [[1, 2], [3, 4], [5, 6]]) == 3
(f1 [13]) == 1 -- True
(f1 ['a', 'b', 'c']) == 3

-- 2
f1 :: Foldable t => t a -> Int
f2 l = foldl (\c x -> c + 1) 0 l 
(f2 [1, 2, 3, 3, 1]) == 5 -- True
(f2 "Hello World") == 11 -- True
(f2 [[1, 2], [3, 4], [5, 6]]) == 3 -- True
(f2 [13]) == 1 -- True
(f2 ['a', 'b', 'c']) == 3 -- True
