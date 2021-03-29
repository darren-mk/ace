-- https://www.4clojure.com/problem/20

-- 1
f1 :: [c] -> c
f1 = head . tail . reverse
(f1 [1, 2, 3, 4, 5]) == 4 -- True 
(f1 ['a', 'b', 'c']) == 'b' -- True
(f1 [[1, 2], [3, 4]]) == [1, 2] -- True
