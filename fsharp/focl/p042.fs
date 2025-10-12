module Focl.P042

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/42
Problem 42, Factorial Fun
Difficulty: easy
Write a function which calculates factorials.
(= (__ 1) 1)
(= (__ 3) 6)
(= (__ 5) 120)
(= (__ 8) 40320)
*)

let samples = [ 1, 1; 3, 6; 5, 120; 8, 40320 ]

let rec f_042_a v =
    match v with
    | 1 -> 1
    | _ -> v * (f_042_a (v - 1))

[<Fact>]
let t_042_a () =
    for v, r in samples do
        f_042_a v |> should equal r

let f_042_b (n: bigint) =
    let rec impl (a: bigint) (x: bigint) =
        if x <= 1I then a else impl (a * x) (x - 1I)

    impl 1I n

[<Fact>]
let t_042_b () = f_042_b 8I |> should equal 40320I
