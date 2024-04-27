module MyTake where

take' 0 _ = []
take' n [] = []
take' n (x:xs) = x : take' (n-1) xs
-- Prelude> take' 3 [1, 2, 3, 4, 5, 6, 7] -- [1,2,3]
