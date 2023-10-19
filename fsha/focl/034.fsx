(*
https://4clojure.oxal.org/#/problem/34
Problem 34, Implement range
Difficulty: easy
Write a function which creates a list of all integers in a given range.
(= (__ 1 4) '(1 2 3))
(= (__ -2 2) '(-2 -1 0 1))
(= (__ 5 8) '(5 6 7))
*)

let va1, vb1, r1 = 1, 4, [1; 2; 3]
let va2, vb2, r2 = -2, 2, [-2; -1; 0; 1]
let va3, vb3, r3 = 5, 8, [5; 6; 7]

let f1 a b = [a .. (b - 1)]
f1 va1 vb1 = r1 // true
f1 va2 vb2 = r2 // true
f1 va3 vb3 = r3 // true

let rec f2 a b = 
  if a = b 
  then []
  else [a] @ (f2 (a + 1) b)
f2 va1 vb1 = r1 // true
f2 va2 vb2 = r2 // true
f2 va3 vb3 = r3 // true