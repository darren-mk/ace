// https://4clojure.oxal.org/#/problem/12

(*
Problem 12, Sequences
Difficulty: elementary
All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
(= __ (first '(3 2 1)))
(= __ (second [2 3 4]))
(= __ (last (list 1 2 3)))
*)

([3; 2; 1][0]).Equals 3
// val it: bool = true

([2; 3; 4][1]).Equals 3
// val it: bool = true

(List.last [1; 2; 3]).Equals 3
// val it: bool = true