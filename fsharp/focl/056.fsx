(*
https://4clojure.oxal.org/#/problem/56
Problem 56, Find Distinct Items
Difficulty: medium
Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
    (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
    (= (__ [:a :a :b :b :c :c]) [:a :b :c])
    (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
    (= (__ (range 50)) (range 50))
*)

let l1, r1 = 
  [1; 2; 1; 3; 1; 2; 4], [1; 2; 3; 4]
let l2, r2 = 
  ["a"; "a"; "b"; "b"; "c"; "c"], ["a"; "b"; "c"]
let l3, r3 = 
  [[2; 4]; [1; 2]; [1; 3]; [1; 3]], [[2; 4]; [1; 2]; [1; 3]]

let f1 l =
  l |> Set.ofList |> Set.toList
f1 l1 = r1 // true
f1 l2 = r2 // true

let f2 l =
  let f acc x = 
    if List.contains x acc then acc else acc @ [x]
  List.fold f [] l
f2 l1 = r1 // true
f2 l2 = r2 // true
f2 l3 = r3 // true