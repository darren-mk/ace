module Focl.P019

open Xunit
open FsUnit.Xunit

(* https://4clojure.oxal.org/#/problem/19
Problem 19
Write a function which returns the last element in a sequence.
(= (__ [1 2 3 4 5]) 5)
(= (__ '(5 4 3)) 3)
(= (__ ["b" "c" "d"]) "d")
Special Restrictions : last *)

let v1 = [ 1; 2; 3; 4; 5 ]
let v2 = [ 5; 4; 3 ]
let v3 = [ 'b'; 'c'; 'd' ]

// 1
let rec f_p019_a l =
    match l with
    | [] -> None
    | [ x ] -> Some x
    | _x :: xs -> f_p019_a xs

[<Fact>]
let test_p019_a () =
    f_p019_a v1 |> should equal (Some 5)
    f_p019_a v2 |> should equal (Some 3)
    f_p019_a v3 |> should equal (Some 'd')

let f_p019_b l = List.rev >> List.head <| l

let f_p019_c = List.last

let rec f_p019_d l =
    match l with
    | [] -> failwith "no item in the collection"
    | [ x ] -> x
    | (_ :: tail) -> f_p019_d tail

let f_p019_e x = List.rev >> List.head <| x

let f_p019_f l = l |> List.rev |> List.head

let rec f_p019_g l =
    match l with
    | [] -> None
    | [ x ] -> Some x
    | _x :: xs -> f_p019_g xs

[<Fact>]
let test_p019_g () =
    f_p019_g v1 |> should equal (Some 5)
    f_p019_g v2 |> should equal (Some 3)
    f_p019_g v3 |> should equal (Some 'd')
