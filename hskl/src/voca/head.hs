module MyHead where

head' [] = error "empty list"
head' [x] = x
head' (x:xs) = x
-- λ> head' [1, 2, 3] -- 1


scanl' _ b [] = [b]
scanl' f b (x:xs) =
  let v = f b x
  in b : scanl' f v xs
-- λ> scanl' (+) 0 [1, 2, 3] -- [0,1,3,6]

scanr' _ b [] = [b]
scanr' f b l =
  let v = f b (last l)
  in scanr' f v (init l) ++ [b]
-- λ> scanr' (+) 0 [1, 2, 3] -- [6,5,3,0]

f $$ x = f x
-- λ> (+2) $$ 1 -- 3

replicate' i x
  | i <= 0 = []
  | otherwise = x : replicate' (i-1) x
-- Prelude> replicate' 3 5 -- [5,5,5]

reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]
-- Prelude> reverse' [1, 2, 3] -- [3,2,1]

repeat' x = x : repeat' x
-- Prelude> take 3 $ repeat' 7 -- [7,7,7]

zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x, y) : zip' xs ys
-- Prelude> zip' [1,2,3] [2,3] -- [(1,2),(2,3)]

elem' _ [] = False
elem' x (y:ys) = x == y || elem' x ys


map' _ [] = []
map' f (x:xs) = f x : map' f xs

 
filter' _ [] = []
filter' p (x:xs)
  | p x = x : filter' p xs
  | otherwise = filter' p xs
-- λ> filter' even [1, 2, 3, 4, 5] -- [2,4]

intersperse' _ [] = []
intersperse' _ [y] = [y]
intersperse' x (y:ys) = y : x : intersperse' x ys
-- λ> intersperse' 0 [1, 2, 3, 4] -- [1,0,2,0,3,0,4]
