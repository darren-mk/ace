module Voca.Max

open Xunit
open FsUnit.Xunit

let max_a l =
    List.reduce (fun a x -> if a < x then x else a) l

[<Fact>]
let test_max_a () =
    max_a [ 1; 2; 3; 4; 5 ] |> should equal 5

let max_b l =
    Seq.reduce (fun a x -> if a > x then a else x) l

[<Fact>]
let test_max_b () =
    max_a [ 1; 2; 3; 4; 5 ] |> should equal 5

let max_c (l: int list) =
    let rec inner (currentMax: int) (remaining: int list) =
        match remaining with
        | [] -> currentMax
        | x :: xs ->
            let newMax = if currentMax > x then currentMax else x
            inner newMax xs

    match l with
    | [] -> None
    | x :: xs -> Some(inner x xs)

[<Fact>]
let test_max_c () =
    max_c [ 1; 2; 3; 4; 5 ] |> should equal (Some 5)

let (<**>) a b =
    match a, b with
    | Some x, Some y -> Some(if x > y then x else y)
    | _, _ -> None

let rec max_d (l: List<int>) : int option =
    match l with
    | [] -> None
    | [ x ] -> Some x
    | x :: xs -> (Some x) <**> (max_d xs)

[<Fact>]
let test_max_d () =
    max_c [ 1; 2; 3; 4; 5 ] |> should equal (Some 5)
