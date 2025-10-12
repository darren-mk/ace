module Focl.P055

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/55
Problem 55, Count Occurences
Difficulty: medium
Write a function which returns a map containing 
the number of occurences of each distinct item in a sequence.
    (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
    (= (__ [:b :a :b :a :b]) {:a 2, :b 3})
    (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
*)

let l1, r1 = [ 1; 1; 2; 3; 2; 1; 1 ], Map.ofList [ 1, 4; 2, 2; 3, 1 ]

let inp_1, exp_1 = [ 1; 1; 2; 3; 2; 1; 1 ], Map.ofList [ 1, 4; 2, 2; 3, 1 ]

let inp_2, exp_2 = [ "b"; "a"; "b"; "a"; "b" ], Map.ofList [ "a", 2; "b", 3 ]

let inp_3, exp_3 =
    [ [ 1; 2 ]; [ 1; 3 ]; [ 1; 3 ] ], Map.ofList [ [ 1; 2 ], 1; [ 1; 3 ], 2 ]

let f_p055_a (l: 'a list) =
    let f (acc: Map<'a, int>) (x: 'a) =
        match acc.TryFind x with
        | None -> acc.Add(x, 1)
        | Some(v: int) -> acc.Add(x, v + 1)

    List.fold f Map.empty l

[<Fact>]
let test_p055_a () =
    f_p055_a inp_1 |> should equal exp_1
    f_p055_a inp_2 |> should equal exp_2
    f_p055_a inp_3 |> should equal exp_3

let f_p055_b (l: 'a list) =
    let f (acc: Map<'a, int>) (x: 'a) =
        match acc.TryFind x with
        | None -> acc.Add(x, 1)
        | Some existing_count -> acc.Add(x, existing_count + 1)

    List.fold f Map.empty l

[<Fact>]
let test_p055_b () =
    f_p055_b inp_1 |> should equal exp_1
    f_p055_b inp_2 |> should equal exp_2
    f_p055_b inp_3 |> should equal exp_3

let f_p055_c (l: 'a list) =
    let rec f (acc: Map<'a, int>) l =
        match l with
        | [] -> acc
        | x :: xs ->
            match acc.TryFind x with
            | None -> f (acc.Add(x, 1)) xs
            | Some exs_count -> f (acc.Add(x, exs_count + 1)) xs

    f Map.empty l

[<Fact>]
let test_p055_c () =
    f_p055_c inp_1 |> should equal exp_1
    f_p055_c inp_2 |> should equal exp_2
    f_p055_c inp_3 |> should equal exp_3
