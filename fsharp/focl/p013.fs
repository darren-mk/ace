module Focl.P013

// https://4clojure.oxal.org/#/problem/13

(*
Problem 13, rest
Difficulty: elementary
The rest function will return all the items of a sequence except the first.
(= __ (rest [10 20 30 40]))
*)

open Xunit
open FsUnit.Xunit

[<Fact>]
let test_p013 () =
    [ 10; 20; 30; 40 ].Tail |> should equal [ 20; 30; 40 ]
