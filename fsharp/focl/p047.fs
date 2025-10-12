module Focl.P047

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/47
Problem 47, Contain Yourself
Difficulty: easy
The contains? function checks if a KEY is present in a given collection. This often leads beginner clojurians to use it incorrectly with numerically indexed collections like vectors and lists.
    (contains? #{4 5 6} __)
    (contains? [1 1 1 1 1] __)
    (contains? {4 :a 2 :b} __)
    (not (contains? [1 2 4] __))
*)

let s = Set.ofList [ 4; 5; 6 ]
let l = [ 1; 1; 1; 1; 1 ]
let m = Map.ofList [ 4, "a"; 2, "b" ]

[<Fact>]
let t_047_a () =
    s.Contains 5 |> should equal true
    Array.tryItem 3 [| 1; 1; 1; 1; 1 |] |> should equal (Some 1)
    m.ContainsKey 4 |> should equal true
