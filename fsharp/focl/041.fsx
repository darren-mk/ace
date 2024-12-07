(*
https://4clojure.oxal.org/#/problem/41
Problem 41, Drop Every Nth Item
Difficulty: easy
Write a function which drops every Nth item from a sequence.
(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
*)

let l1, v1, r1 = 
  [1; 2; 3; 4; 5; 6; 7; 8], 3, [1; 2; 4; 5; 7; 8]
let l3, v3, r3 = 
  [1; 2; 3; 4; 5; 6], 4, [1; 2; 3; 5; 6]

let f1 l v = 
  let f acc item = 
    let (newL, ind) = acc
    if ind <= 1 
    then (newL, v)
    else (newL @ [item], ind - 1)
  List.fold f ([], v) l |> fst
f1 l1 v1 = r1 // true
f1 l3 v3 = r3 // true