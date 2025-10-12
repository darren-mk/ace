module Focl.P038

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/38
Problem 38, Maximum value
Difficulty: easy
Write a function which takes a variable number of parameters and returns the maximum value.
(= (__ 1 8 3 4) 8)
(= (__ 30 20) 30)
(= (__ 45 67 11) 67)
*)

let l1, r1 = [ 1; 8; 3; 4 ], 8
let l2, r2 = [ 30; 20 ], 30
let l3, r3 = [ 45; 67; 11 ], 67

let f_p038_a l =
    let f mx x = if mx > x then mx else x
    List.fold f (List.head l) l

[<Fact>]
let test_p038_a () =
    f_p038_a l1 |> should equal r1 // true
    f_p038_a l2 |> should equal r2 // true
    f_p038_a l3 |> should equal r3 // true

let f_p038_b l = List.sort >> List.last <| l

[<Fact>]
let test_p038_b () =
    f_p038_b l1 |> should equal r1 // true
    f_p038_b l2 |> should equal r2 // true
    f_p038_b l3 |> should equal r3 // true

let rec f_p038_c l =
    let f (a: int) (b: int) = if a > b then a else b

    match l with
    | [] -> failwith "should not reach"
    | [ x ] -> x
    | x :: xs -> f x (f_p038_c xs)

[<Fact>]
let test_p038_c () =
    f_p038_c l1 |> should equal r1 // true
    f_p038_c l2 |> should equal r2 // true
    f_p038_c l3 |> should equal r3 // true

let rec f_p038_d l =
    let (<@>) a b =
        match a, b with
        | None, None -> None
        | Some x, None -> Some x
        | None, Some y -> Some y
        | Some x, Some y -> if x > y then Some x else Some y

    match l with
    | [] -> None
    | x :: xs -> Some x <@> f_p038_d xs

[<Fact>]
let test_p038_d () =
    f_p038_d l1 |> should equal (Some r1)
    f_p038_d l2 |> should equal (Some r2)
    f_p038_d l3 |> should equal (Some r3)

let f_038_e (l: 'a list) =
    let f (cur_max_opt: 'a option) (item: 'a) =
        match cur_max_opt with
        | None -> Some item
        | Some x -> if x < item then Some item else Some x

    List.fold f None l

[<Fact>]
let t_038_e () =
    f_038_e l1 |> should equal (Some r1)
    f_038_e l2 |> should equal (Some r2)
    f_038_e l3 |> should equal (Some r3)
