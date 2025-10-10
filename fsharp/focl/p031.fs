module Focl.P031

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/31
Problem 31, Pack a Sequence
Difficulty: easy
Write a function which packs consecutive duplicates into sub-lists.
(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
*)

let v1 = [ 1; 1; 2; 1; 1; 1; 3; 3 ]

let r1 = [ [ 1; 1 ]; [ 2 ]; [ 1; 1; 1 ]; [ 3; 3 ] ]

let f_p031_a l =
    let butlast = List.rev >> List.tail >> List.rev

    let f (acc: 'a list list) (item: 'a) =
        match acc with
        | [ [] ] -> [ [ item ] ]
        | _ ->
            if acc |> List.last |> List.last = item then
                let y = ((List.last acc) @ [ item ])
                (butlast acc) @ [ y ]
            else
                acc @ [ [ item ] ]

    List.fold f [ [] ] l

[<Fact>]
let test_p031_a () = f_p031_a v1 |> should equal r1
