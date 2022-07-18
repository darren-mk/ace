-- https://www.4clojure.com/problem/19

-- 1
f1 :: [a] -> a
f1 l = last l 
(f1 [1, 2, 3, 4, 5]) == 5 -- True
(f1 [5, 4, 3]) == 3 -- True
(f1 ['b', 'c', 'd']) == 'd' -- True

-- 2
f2 :: [a] -> a
f2 l = (head (reverse l))
(f2 [1, 2, 3, 4, 5]) == 5 -- True
(f2 [5, 4, 3]) == 3 -- True
(f2 ['b', 'c', 'd']) == 'd' -- True

-- 3
f3 :: [a] -> a
f3 = head . reverse
(f3 [1, 2, 3, 4, 5]) == 5 -- True
(f3 [5, 4, 3]) == 3 -- True
(f3 ['b', 'c', 'd']) == 'd' -- True
