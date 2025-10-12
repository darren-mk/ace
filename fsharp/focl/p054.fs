module Focl.P054

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/54
Problem 54, Partition a Sequence
Difficulty: medium
Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
    (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
    (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
    (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))
*)

let samples =
    [ (3, seq { 0..8 }), [| [| 0; 1; 2 |]; [| 3; 4; 5 |]; [| 6; 7; 8 |] |]
      (2, seq { 0..7 }), [| [| 0; 1 |]; [| 2; 3 |]; [| 4; 5 |]; [| 6; 7 |] |]
      (3, seq { 0..7 }), [| [| 0; 1; 2 |]; [| 3; 4; 5 |] |] ]

let f_p054_a (size: int) (col: int seq) : int array array =
    col
    |> Seq.chunkBySize size
    |> Seq.filter (fun chunk -> Array.length chunk = size)
    |> Seq.map Array.ofSeq
    |> Array.ofSeq

[<Fact>]
let test_p054_a () =
    for (size, col), exp in samples do
        f_p054_a size col |> should equal exp

let f_p054_b size col =
    let rec f acc rest =
        match List.splitAt size rest with
        | chunk, tail when List.length chunk = size -> f (chunk :: acc) tail
        | _ -> List.rev acc

    f [] (List.ofSeq col)
