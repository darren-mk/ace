(*
https://4clojure.oxal.org/#/problem/18
Problem 18, filter
Difficulty: elementary
The filter function takes two arguments: 
a predicate function (f) and a sequence (s). 
Filter returns a new sequence consisting of 
all the items of s for which (f item) returns true.
(= __ (filter #(> % 5) '(3 4 5 6 7)))
*)

let f x = x > 5
List.filter f [3; 4; 5; 6; 7] // [6; 7]
Array.filter f [| 3; 4; 5; 6; 7 |] // [|6; 7|]
Seq.filter f [3 .. 7] // seq [6; 7]