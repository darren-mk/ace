-- https://www.4clojure.com/problem/25

-- 1
f1 :: Integral a => [a] -> [a]
f1 l = filter (\x -> (mod x 2) == 1) l
(f1 [1, 2, 3, 4, 5]) == [1, 3, 5] -- True
(f1 [4, 2, 1, 6]) == [1] -- True
(f1 [2, 2, 4, 6]) == [] -- True
(f1 [1, 1, 1, 3]) == [1, 1, 1, 3] -- True
