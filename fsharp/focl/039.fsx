(*
https://4clojure.oxal.org/#/problem/39
Problem 39, Interleave Two Seqs
Difficulty: easy
Write a function which takes two sequences and returns 
the first item from each, then the second item from each, 
then the third, etc.
(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
(= (__ [1 2 3 4] [5]) [1 5])
(= (__ [30 20] [25 15]) [30 25 20 15])
*)

let a1, b1, r1 = 
  [1; 2; 3], [7; 8; 9], [1; 7; 2; 8; 3; 9]
let a2, b2, r2 = 
  [1; 2; 3; 4], [5], [1; 5]

let rec f1 a b = 
  match a, b with 
  | _, [] | [], _ -> []
  | x::xs, y::ys -> [x; y] @ (f1 xs ys)
f1 a1 b1 = r1 // true
f1 a2 b2 = r2 // true