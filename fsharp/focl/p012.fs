module Focl.P012

open Xunit
open FsUnit.Xunit

// https://4clojure.oxal.org/#/problem/12
(*
Problem 12, Sequences
Difficulty: elementary
All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
(= __ (first '(3 2 1)))
(= __ (second [2 3 4]))
(= __ (last (list 1 2 3)))
*)

[<Fact>]
let test_p012 () =
    [ 3; 2; 1 ][0] |> should equal 3
    [ 2; 3; 4 ][1] |> should equal 3
    List.last [ 1; 2; 3 ] |> should equal 3
