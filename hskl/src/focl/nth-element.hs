module Focl where
-- https://www.4clojure.com/problem/21

-- 1
f1 l n
  = fst
  $ head
  $ filter (\x -> snd x == n) (zip l [0..])
--f1 [4, 5, 6, 7] 2 == 6 -- True  
-- f1 ['a', 'b', 'c'] 0 == 'a' -- True
--f1 [1, 2, 3, 4] 1 == 2 -- True
--f1 [[1, 2], [3, 4], [5, 6]] 2 == [5, 6] -- True
