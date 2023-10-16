(*
https://4clojure.oxal.org/#/problem/30
Problem 30, Compress a Sequence
Difficulty: easy
Write a function which removes consecutive duplicates from a sequence.
(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
*)

let v1, r1 = 
  [1; 1; 2; 3; 3; 2; 2; 3], [1; 2; 3; 2; 3]
let v2, r2 = 
  [[1; 2]; [1; 2]; [3; 4]; [1; 2]], [[1; 2]; [3; 4]; [1; 2]]

let f1 l =
  let f acc item = 
    match acc with
    | [] -> [item]
    | _ -> if List.last acc = item then acc else acc @ [item]
  List.fold f [] l
f1 v1 = r1 // true
f1 v2 = r2 // true