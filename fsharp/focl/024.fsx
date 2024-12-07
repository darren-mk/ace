(*
https://4clojure.oxal.org/#/problem/24
Problem 24, Sum It All Up
Difficulty: easy
Write a function which returns the sum of a sequence of numbers.
(= (__ [1 2 3]) 6)
(= (__ (list 0 -2 5 5)) 8)
(= (__ #{4 2 1}) 7)
(= (__ '(0 0 -1)) -1)
(= (__ '(1 10 3)) 14)
*)

let v1, r1 = [1; 2; 3], 6
let v2, r2 = [0; -2; 5; 5], 8
let v3, r3 = [4; 2; 1], 7
let v4, r4 = [0; 0; -1], -1
let v5, r5 = [1; 10; 3], 14

let f1 l =
  List.fold (fun acc item -> acc + item) 0 l
f1 v1 = r1
f1 v2 = r2
f1 v3 = r3
f1 v4 = r4
f1 v5 = r5

let rec f2 l = 
  match l with
  | [] -> 0
  | (x::xs) -> x + (f2 xs)
f2 v1 = r1
f2 v2 = r2
f2 v3 = r3
f2 v4 = r4
f2 v5 = r5