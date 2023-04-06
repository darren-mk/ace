module AssociationLists where

al = [(1, "one"), (2, "two"), (3, "three")]
-- λ> lookup 1 al
-- Just "one"
-- λ> lookup 3 al
-- Just "three"

lookup' :: Eq a => a -> [(a, b)] -> Maybe b
lookup' _ [] = Nothing
lookup' k l =
  if k == (fst . head $ l)
  then Just (snd . head $ l)
  else lookup' k (tail l)
