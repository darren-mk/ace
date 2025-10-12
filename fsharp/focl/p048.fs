module Focl.P048

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/48
Problem 48, Intro to some
Difficulty: easy
The some function takes a predicate function and a collection. It returns the first logical true value of (predicate x) where x is an item in the collection.
    (= __ (some #{2 7 6} [5 6 7 8]))
    (= __ (some #(when (even? %) %) [5 6 7 8]))
*)

let l1 = [ 5; 6; 7; 8 ]

let f_048_a pred l =
    List.map (fun (x: int) -> pred x) l |> List.contains true

[<Fact>]
let t_048_a () =
    f_048_a (fun x -> x < 6) l1 |> should equal true
    f_048_a (fun x -> x < 3) l1 |> should equal false

let f_048_b pred l =
    let f b x =
        match b with
        | true -> true
        | false -> pred x

    List.fold f false l

[<Fact>]
let t_048_b () =
    f_048_b (fun x -> x < 6) l1 |> should equal true
    f_048_b (fun x -> x < 3) l1 |> should equal false
