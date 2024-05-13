(*
https://4clojure.oxal.org/#/problem/48
Problem 48, Intro to some
Difficulty: easy
The some function takes a predicate function and a collection. It returns the first logical true value of (predicate x) where x is an item in the collection.
    (= __ (some #{2 7 6} [5 6 7 8]))
    (= __ (some #(when (even? %) %) [5 6 7 8]))
*)

let l1 = [5; 6; 7; 8]

let f1 pred l =
  List.map (fun (x: int) -> pred x) l
  |> List.contains true 
f1 (fun x -> x < 6) l1 = true
f1 (fun x -> x < 3) l1 = false 