module Focl.P053

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/53
Problem 53, Longest Increasing Sub-Seq
Difficulty: hard
Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.
    (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
    (= (__ [5 6 1 3 2 7]) [5 6])
    (= (__ [2 3 3 4 5]) [3 4 5])
    (= (__ [7 6 5 4]) [])
*)

let test_sets =
    [ [ 1; 0; 1; 2; 3; 0; 4; 5 ], [ 0; 1; 2; 3 ]
      [ 5; 6; 1; 3; 2; 7 ], [ 5; 6 ]
      [ 2; 3; 3; 4; 5 ], [ 3; 4; 5 ]
      [ 7; 6; 5; 4 ], [] ]

type Inner =
    { longest: int list
      candidate: int list }

let f_p053_a (l: int list) =
    let f (acc: Inner) x =
        let candidate': int list =
            match acc.candidate with
            | [] -> [ x ]
            | existing ->
                if (List.last existing) + 1 = x then
                    acc.candidate @ [ x ]
                else
                    [ x ]

        let longest': int list =
            if List.length acc.longest > List.length candidate' then
                acc.longest
            else
                candidate'

        { candidate = candidate'
          longest = longest' }

    let calc = List.fold f { longest = []; candidate = [] } l

    match calc.longest with
    | [] -> []
    | [ x ] -> []
    | xs -> xs

[<Fact>]
let test_p053_a () =
    for input, exp in test_sets do
        f_p053_a input |> should equal exp

type LI = int list
type LA = int array

let rec f_p053_b_impl (longest: LA) (candidate: LA) (l: LI) : LI =
    match l with
    | [] ->
        if Array.length longest < Array.length candidate then
            List.ofArray candidate
        else
            List.ofArray longest
    | x :: xs ->

        if Array.isEmpty candidate || Array.last candidate < x then
            f_p053_b_impl longest (Array.append candidate [| x |]) xs
        else if Array.length longest < Array.length candidate then
            f_p053_b_impl candidate [| x |] xs
        else
            f_p053_b_impl longest [| x |] xs

let f_p053_b (l: LI) = f_p053_b_impl [||] [||] l
