module MyQuicksort where

quicksort' [] = []
quicksort' [x] = [x]
quicksort' (x:xs) =
  let biggersOrSame = quicksort' [y | y <- xs, y >= x ]
      smallers = quicksort' [y | y <- xs, y < x ]
  in smallers ++ [x] ++ biggersOrSame
-- Prelude> quicksort' [1, 2, 4] -- [1,2,4]
-- Prelude> quicksort' [1] -- [1]
-- Prelude> quicksort' [4, 5, 2, 6, 4, 5] -- [2,4,4,5,5,6]
-- Prelude> quicksort' [4, 5, 2, 3, 2, 1, 3] -- [1,2,2,3,3,4,5]

quicksort'' [] = []
quicksort'' (x:xs) =
  let biggersOrSame = filter (>= x) xs
      smallers = filter (< x) xs
  in smallers ++ [x] ++ biggersOrSame
-- λ> quicksort'' [2, 3, 1, 4, 5, 4] -- [1,2,3,4,5,4]
