module Focl.P044

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/44
Problem 44, Rotate Sequence
Difficulty: medium
Write a function which can rotate a sequence in either direction.
    (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
    (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
    (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
    (= (__ 1 '(:a :b :c)) '(:b :c :a))
    (= (__ -4 '(:a :b :c)) '(:c :a :b))
*)

let f_044_a (n: int) (arr: int array) =
    let size = arr.Length
    let front = if n > 0 then n % size else abs n
    Array.append arr[front - 1 ..] arr[0 .. front - 2]

//f_044_a 2 [| 1; 2; 3; 4; 5 |]
//f_044_a -2 [| 1; 2; 3; 4; 5 |]
//f_044_a 6 [| 1; 2; 3; 4; 5 |]
