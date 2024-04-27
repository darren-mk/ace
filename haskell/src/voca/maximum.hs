module MyMaximum where

maximum' [] = error "empty list"
maximum' [x] = x
maximum' (x:xs)
  | x > maxInTail = x
  | otherwise = maxInTail
  where maxInTail = maximum' xs
