module Focl.P045

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/45
Problem 45, Intro to Iterate
Difficulty: easy
The iterate function can be used to produce an infinite lazy sequence.
    (= __ (take 5 (iterate #(+ 3 %) 1)))
*)

let f_045_a f start = seq { for i in start..100 -> f i }

[<Fact>]
let t_045_a () =
    f_045_a (fun x -> x * 5) 3
    |> Seq.take 5
    |> Array.ofSeq
    |> should equal [| 15; 20; 25; 30; 35 |]

let f_045_b f start =
    Seq.initInfinite (fun i -> f (i + start))

[<Fact>]
let t_045_b () =
    f_045_b (fun x -> x * 5) 3
    |> Seq.take 5
    |> Array.ofSeq
    |> should equal [| 15; 20; 25; 30; 35 |]
