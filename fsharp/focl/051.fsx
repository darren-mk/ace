(*
https://4clojure.oxal.org/#/problem/51
Problem 51, Advanced Destructuring
Difficulty: easy
Here is an example of some more sophisticated destructuring.
    (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
*)

let (a, b, (x, y, z), d) = 
  (1, 2, (3, 4, 5), [1; 2; 3; 4; 5])
a // 1
b // 2
x // 3
d // [1; 2; 3; 4; 5]