(*
https://4clojure.oxal.org/#/problem/42
Problem 42, Factorial Fun
Difficulty: easy
Write a function which calculates factorials.
(= (__ 1) 1)
(= (__ 3) 6)
(= (__ 5) 120)
(= (__ 8) 40320)
*)

let v1, r1 = 1, 1
let v2, r2 = 3, 6
let v3, r3 = 5, 120
let v4, r4 = 8, 40320

let rec f1 v =
  match v with
  | 1 -> 1
  | _ -> v * (f1 (v - 1))
f1 v1 = r1 // true
f1 v2 = r2 // true
f1 v3 = r3 // true
f1 v4 = r4 // true