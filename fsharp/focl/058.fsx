(*
https://4clojure.oxal.org/#/problem/58
Problem 58, Function Composition
Difficulty: medium
Write a function which allows you to create function compositions. 
The parameter list should take a variable number of functions, 
and create a function applies them from right-to-left.
    (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
    (= 5 ((__ (partial + 3) second) [1 2 3 4]))
    (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
    (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
*)

let l1, r1 = [1; 2; 3; 4], [3; 2; 1]

let f1 fa fb =
  fun x -> x |> fb |> fa
f1 List.tail List.rev <| l1 // [3; 2; 1]