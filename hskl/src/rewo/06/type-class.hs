{-# LANGUAGE FlexibleInstances #-}

module TypeClass where

data Color = Red | Green | Blue

class BasicEq a where
  isEqual :: a -> a -> Bool

instance BasicEq Bool where
  isEqual True True = True
  isEqual False False = True
  isEqual _ _ = False

instance BasicEq Color where
  isEqual Red Red = True
  isEqual Green Green = True
  isEqual Blue Blue = True
  isEqual _ _ = False

instance BasicEq String where
  isEqual x y =
    x == y


