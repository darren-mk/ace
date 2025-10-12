module Focl.P046

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/46
Problem 46, Flipping out
Difficulty: medium
Write a higher-order function which flips the order of the arguments of an input function.
    (= 3 ((__ nth) 2 [1 2 3 4 5]))
    (= true ((__ >) 7 8))
    (= 4 ((__ quot) 2 8))
    (= [1 2 3] ((__ take) [1 2 3 4 5] 3))
*)

let f1 (f: 'a -> 'b -> 'c) : ('b -> 'a -> 'c) = fun (x: 'b) (y: 'a) -> f y x

[<Fact>]
let t_046_a () =
    let f = f1 (fun (x: int) (y: int) -> x > y)
    f 7 8 |> should equal true
