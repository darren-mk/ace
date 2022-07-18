module Sum where

sum' [] = 0
sum' (x:xs) = foldl (+) x xs
-- λ> sum' [1, 2, 3] -- 6
