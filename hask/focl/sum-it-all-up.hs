-- https://www.4clojure.com/problem/24

-- 1
f1 :: (Foldable t, Num a) => t a -> a
f1 l = foldl (\s x -> s + x) 0 l
(f1 [1, 2, 3]) == 6
(f1 [0, -2, 5, 5]) == 8
(f1 [4, 2, 1]) == 7
(f1 [0, 0, -1]) == -1
(f1 [1, 10, 3]) == 14
