module Focl.P028

(*
https://4clojure.oxal.org/#/problem/28
Problem 28, Flatten a Sequence
Difficulty: easy
Write a function which flattens a sequence.
(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
(= (__ '((((:a))))) '(:a))
*)

// let v1, r1 = [[1; 2]; 3; [4; [5; 6]]], [1; 2; 3; 4; 5; 6]
// let v2, r2 = ["a"; ["b"]; "c"], ["a"; "b"; "c"]
// f# doesn't allow nested types
