module Voca.Filter

open Xunit
open FsUnit.Xunit

let rec filter_a f l =
    match l with
    | [] -> []
    | x :: xs -> if f x then x :: filter_a f xs else filter_a f xs

[<Fact>]
let test_filter_a () =
    filter_a (fun x -> x % 2 = 0) [ 1; 2; 3; 4; 5 ] |> should equal [ 2; 4 ]

let filter_b f l =
    List.fold (fun a x -> if f x then a @ [ x ] else a) [] l

[<Fact>]
let test_filter_b () =
    filter_b (fun x -> x % 2 = 0) [ 1; 2; 3; 4; 5 ] |> should equal [ 2; 4 ]

let rec filter_c f l =
    match l with
    | [] -> []
    | x :: xs -> if f x then x :: filter_c f xs else filter_c f xs

[<Fact>]
let test_filter_c () =
    filter_c (fun x -> x % 2 = 0) [ 1; 2; 3; 4; 5 ] |> should equal [ 2; 4 ]
