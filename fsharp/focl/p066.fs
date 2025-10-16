module Focl.P066

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/66
Problem 66, Greatest Common Divisor
Difficulty: easy
Given two integers, write a function which
returns the greatest common divisor.
    (= (__ 2 4) 2)
    (= (__ 10 5) 5)
    (= (__ 5 7) 1)
    (= (__ 1023 858) 33)
*)

let f066a a b =
    let isDivisible dividee divisor = dividee % divisor = 0
    let isBothDibisible x = isDivisible a x && isDivisible b x
    let smaller = List.min [ a; b ]

    let f greatest candidate =
        if isBothDibisible candidate then candidate else greatest

    List.fold f 1 [ 1..smaller ]

[<Fact>]
let t066a () =
    f066a 2 4 |> should equal 2
    f066a 10 5 |> should equal 5
    f066a 5 7 |> should equal 1
    f066a 1023 858 |> should equal 33

let is_divisible dividee divisor = dividee % divisor = 0

let are_both_divisible a b divisor =
    is_divisible a divisor || is_divisible b divisor

let rec some f l =
    match l with
    | [] -> None
    | x :: xs -> if f x then Some x else some f xs

let f066b x y =
    let lesser = min x y
    let candidates = [ lesser .. -1 .. 2 ]
    let pred = fun divisor -> are_both_divisible x y divisor
    some pred candidates

let t066b () =
    let samples = [ 2, 4, 2; 10, 5, 10; 5, 7, 1; 1032, 858, 33 ]

    for a, b, exp in samples do
        f066b a b |> should equal (Some exp)
