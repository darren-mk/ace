module Focl.P041

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/41
Problem 41, Drop Every Nth Item
Difficulty: easy
Write a function which drops every Nth item from a sequence.
(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
*)

let l1, n1, r1 = [ 1; 2; 3; 4; 5; 6; 7; 8 ], 3, [ 1; 2; 4; 5; 7; 8 ]
let l2, n2, r2 = [ 'a'; 'b'; 'c'; 'd'; 'e'; 'f' ], 2, [ 'a'; 'c'; 'e' ]
let l3, n3, r3 = [ 1; 2; 3; 4; 5; 6 ], 4, [ 1; 2; 3; 5; 6 ]

let f_041_a l v =
    let f acc item =
        let (newL, ind) = acc
        if ind <= 1 then (newL, v) else (newL @ [ item ], ind - 1)

    List.fold f ([], v) l |> fst

[<Fact>]
let t_041_a () =
    f_041_a l1 n1 |> should equal r1
    f_041_a l2 n2 |> should equal r2
    f_041_a l3 n3 |> should equal r3

let f_041_b (l: 'a list) (n: int) =
    let f (acc: 'a list * int) item =
        let res, ind = acc
        if ind >= n then res, 1 else res @ [ item ], ind + 1

    List.fold f ([], 1) l |> fst

[<Fact>]
let t_041_b () =
    f_041_b l1 n1 |> should equal r1
    f_041_b l2 n2 |> should equal r2
    f_041_b l3 n3 |> should equal r3
