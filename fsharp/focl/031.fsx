(*
https://4clojure.oxal.org/#/problem/31
Problem 31, Pack a Sequence
Difficulty: easy
Write a function which packs consecutive duplicates into sub-lists.
(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
*)

let v1, r1 = 
  [1; 1; 2; 1; 1; 1; 3; 3], [[1; 1]; [2]; [1; 1; 1]; [3; 3]]

let f1 l =
  let butlast = List.rev >> List.tail >> List.rev
  let f (acc: 'a list list) (item: 'a) =
    match acc with 
    | [[]] -> [[item]]
    | _ ->
      if acc |> List.last |> List.last = item
      then 
        let y = ((List.last acc) @ [item])
        (butlast acc) @ [y]
      else acc @ [[item]]
  List.fold f [[]] l
f1 v1 = r1