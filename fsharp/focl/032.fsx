(*
https://4clojure.oxal.org/#/problem/32
Problem 32, Duplicate a Sequence
Difficulty: easy
Write a function which duplicates each element of a sequence.
(= (__ [1 2 3]) '(1 1 2 2 3 3))
(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (__ [44 33]) [44 44 33 33])
*)

let v1, r1 = 
  [1; 2; 3], [1; 1; 2; 2; 3; 3]
let v3, r3 = 
  [[1; 2]; [3; 4]], [[1; 2]; [1; 2]; [3; 4]; [3; 4]]

let f1 l =
  List.fold (fun acc item -> acc @ [item; item]) [] l
f1 v1 = r1 // true
f1 v3 = r3 // true

let rec f2 l =
  match l with
  | [] -> []
  | head :: tail -> [head; head] @ (f2 tail)
f2 v1 = r1 // true
f2 v3 = r3 // true