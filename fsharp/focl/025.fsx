(*
https://4clojure.oxal.org/#/problem/25
Problem 25, Find the odd numbers
Difficulty: easy
Write a function which returns only the odd numbers from a sequence.
(= (__ #{1 2 3 4 5}) '(1 3 5))
(= (__ [4 2 1 6]) '(1))
(= (__ [2 2 4 6]) '())
(= (__ [1 1 1 3]) '(1 1 1 3))
*)

let v1, r1 = [1; 2; 3; 4; 5], [1; 3; 5]
let v2, r2 = [4; 2; 1; 6], [1]
let v3, r3 = [2; 2; 4; 6], []
let v4, r4 = [1; 1; 1; 3], [1; 1; 1; 3]

let f1 l =
  List.filter (fun item -> item % 2 = 1) l
f1 v1 = r1
f1 v2 = r2
f1 v3 = r3
f1 v4 = r4

let rec f2 l = 
  match l with
  | [] -> []
  | (x::xs) -> 
    if x % 2 = 1 
    then [x] @ (f2 xs)
    else (f2 xs)
f1 v1 = r1
f1 v2 = r2
f1 v3 = r3
f1 v4 = r4 