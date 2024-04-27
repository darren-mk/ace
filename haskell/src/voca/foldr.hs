module Foldr where

foldr' f b [] = b
foldr' f b l = foldr' f (f b (last l)) (init l)
-- λ> foldr (\ac x -> ac * x) 10 [1, 2, 3] -- 60
-- λ> foldr' (+) 100 [1, 2, 3] -- 106
