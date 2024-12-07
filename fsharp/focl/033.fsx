(*
https://4clojure.oxal.org/#/problem/33
Problem 33, Replicate a Sequence
Difficulty: easy
Write a function which replicates each element of a sequence a variable number of times.
(= (__ [1 2 3] 2) '(1 1 2 2 3 3))
(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (__ [4 5 6] 1) '(4 5 6))
(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (__ [44 33] 2) [44 44 33 33])
*)

let l1, n1, r1 = 
  [1; 2; 3], 2, [1; 1; 2; 2; 3; 3;]
let l2, n2, r2 =  
  ["a"; "b"], 4, ["a"; "a"; "a"; "a"; "b"; "b"; "b"; "b"]
let l3, n3, r3 = 
  [4; 5; 6], 1, [4; 5; 6]

let f1 l n =
  let lfold = List.fold
  let lrep = List.replicate
  let f acc item = acc @ (lrep n item)
  List.fold f [] l
f1 l1 n1 = r1 // true
f1 l2 n2 = r2 // true
f1 l3 n3 = r3 // true

let rec f2 l n =
  let lrep = List.replicate
  match l with
  | [] -> []
  | head :: tail -> lrep n head @ (f2 tail n)
f2 l1 n1 = r1 // true
f2 l2 n2 = r2 // true
f2 l3 n3 = r3 // true