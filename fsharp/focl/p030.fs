module Focl.P030

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/30
Problem 30, Compress a Sequence
Difficulty: easy
Write a function which removes consecutive duplicates from a sequence.
(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
*)

let v1, r1 = [ 1; 1; 2; 3; 3; 2; 2; 3 ], [ 1; 2; 3; 2; 3 ]

let v2, r2 =
    [ [ 1; 2 ]; [ 1; 2 ]; [ 3; 4 ]; [ 1; 2 ] ], [ [ 1; 2 ]; [ 3; 4 ]; [ 1; 2 ] ]

let f_p030_a l =
    let f acc item =
        match acc with
        | [] -> [ item ]
        | _ -> if List.last acc = item then acc else acc @ [ item ]

    List.fold f [] l

[<Fact>]
let test_p030_a () =
    f_p030_a v1 |> should equal r1
    f_p030_a v2 |> should equal r2

let rec f_p030_b_impl acc l =
    match acc, l with
    | _, [] -> acc
    | [], x :: xs -> f_p030_b_impl (acc @ [ x ]) xs
    | _, x :: xs ->
        let acc' = if x = List.last acc then acc else acc @ [ x ]
        f_p030_b_impl acc' xs

let f_p030_b l = f_p030_b_impl [] l

[<Fact>]
let test_p030_b () =
    f_p030_b [] |> should equal []
    f_p030_b v1 |> should equal r1
    f_p030_b v2 |> should equal r2
