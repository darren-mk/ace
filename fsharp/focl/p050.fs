module Focl.P050

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/50
Problem 50, Split by Type
Difficulty: medium
Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).
    (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
    (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
    (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
*)

type Arg =
    | I of int
    | Is of int list
    | S of string

let input = [ I 1; S "a"; I 2; S "b"; I 3; S "c"; Is [ 1; 2; 3 ] ]

let f_p050_a (args: Arg list) =
    let fI arg =
        match arg with
        | I _ -> true
        | _ -> false

    let fIs arg =
        match arg with
        | Is _ -> true
        | _ -> false

    let fS arg =
        match arg with
        | S _ -> true
        | _ -> false

    let i = List.filter fI args
    let is = List.filter fIs args
    let s = List.filter fS args
    [ i; is; s ] |> List.filter (fun elem -> not elem.IsEmpty) |> Set.ofList

type ArgKey =
    | IK
    | IsK
    | SK

let rec f_p050_b_impl (acc: Map<ArgKey, Arg>) (args: Arg list) =
    match args with
    | [] -> acc
    | x :: xs ->
        match x with
        | I _v -> f_p050_b_impl (acc.Add(IK, x)) xs
        | Is _v -> f_p050_b_impl (acc.Add(IsK, x)) xs
        | S _v -> f_p050_b_impl (acc.Add(SK, x)) xs

let f_p050_b (args: Arg list) = f_p050_b_impl Map.empty args
