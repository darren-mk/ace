module Dollar where
import GHC.IO.Encoding.UTF16 (utf16_encode, utf16)
import Distribution.Simple.Utils (xargs)

f $$ x = f x
v = map ($$ 3) [(4+), (10*), (^2), sqrt]
-- λ> v -- [7.0,30.0,9.0,1.7320508075688772] 

factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial 1 = 1
factorial x = x * factorial (x - 1)

squareFive :: (Integral a) => a -> a
squareFive x = 5 ^ x

ev :: (Fractional a, Integral a) => a -> a
ev x = squareFive x / factorial x
