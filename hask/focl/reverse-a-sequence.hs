-- https://www.4clojure.com/problem/23

-- 1
f1 [] = []
f1 (x:xs) = (f1 xs) ++ x
