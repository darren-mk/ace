module Focl.P017

open Xunit
open FsUnit.Xunit

// https://4clojure.oxal.org/#/problem/17

(*
Problem 17, map
Difficulty: elementary
The map function takes two arguments: a function (f) and a sequence (s). 
Map returns a new sequence consisting of the result of applying f to each item of s. 
Do not confuse the map function with the map data structure.
(= __ (map #(+ % 5) '(1 2 3)))
*)

[<Fact>]
let test_p017_a () =
    let f x = x + 5
    Array.map f [| 1; 2; 3 |] |> should equal [| 6; 7; 8 |]
    List.map f [ 1; 2; 3 ] |> should equal [ 6; 7; 8 ]
    Seq.map f { 1..3 } |> should equalSeq { 6..8 }
