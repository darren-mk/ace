module Foldl where

foldl' f bs [] = bs
foldl' f bs (x:xs) = foldl' f (f bs x) xs
-- λ> foldl' (\ac x -> ac + x) 100 [1, 2, 3] -- 106
-- λ> foldl' (+) 100 [1, 2, 3] -- 106
