module Lib where

import Prelude

-- https://www.geeksforgeeks.org/linear-search/

ls [] _ = False
ls (x:xs) v = (x == v) || ls xs v
-- λ> ls [1, 2, 3, 4, 5] 3 -- True
-- λ> ls [1, 2, 3, 4, 5] 7 -- False
-- λ> ls [1, 2, 3, 4, 5] 0 -- False
-- λ> ls [1, 2, 3, 4, 5] 1 -- True

--  https://www.geeksforgeeks.org/binary-search/

midIndex :: Foldable t => t a -> Int
midIndex l = quot (length l) 2

bs :: [Int] -> Int -> Int
bs [] _ = False
bs l v =
  let nl = zip [0..] l
      mi = midIndex l    
      a = filter (\e -> fst e < mi ) nl  
      b = filter (\e -> fst e >= mi) nl
  in
    cond [ (null a || null b, -1)
         , ((snd . last $ a) == v, fst . last $ a)
         , ((snd . head $ b) == v, fst . head $ b)
         , (otherwise , 0)]
    
