module Focl.P049

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/49
Problem 49, Split a sequence
Difficulty: easy
Write a function which will split a sequence into two parts.
    (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
    (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
    (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])
*)

let n1, l1, r1 = 3, [ 1..6 ], [ [ 1..3 ]; [ 4..6 ] ]

let n2, l2, r2 = 1, [ "a"; "b"; "c"; "d" ], [ [ "a" ]; [ "b"; "c"; "d" ] ]

let n3, l3, r3 =
    2, [ [ 1; 2 ]; [ 3; 4 ]; [ 5; 6 ] ], [ [ [ 1; 2 ]; [ 3; 4 ] ]; [ [ 5; 6 ] ] ]

let f_p049_a (n: int) (l: 'a list) = [ l[0 .. (n - 1)]; l[n..] ]

[<Fact>]
let test_p049_a () =
    f_p049_a n1 l1 |> should equal r1
    f_p049_a n2 l2 |> should equal r2
    f_p049_a n3 l3 |> should equal r3
