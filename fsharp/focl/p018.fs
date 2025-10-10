module Focl.P018

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/18
Problem 18, filter
Difficulty: elementary
The filter function takes two arguments: 
a predicate function (f) and a sequence (s). 
Filter returns a new sequence consisting of 
all the items of s for which (f item) returns true.
(= __ (filter #(> % 5) '(3 4 5 6 7)))
*)

[<Fact>]
let test_p018_a () =
    let pred x = 5 < x
    Array.filter pred [| 3; 4; 5; 6; 7 |] |> should equal [| 6; 7 |]
    List.filter pred [ 3; 4; 5; 6; 7 ] |> should equal [ 6; 7 ]
    Seq.filter pred { 3..7 } |> should equalSeq (seq [ 6; 7 ])
