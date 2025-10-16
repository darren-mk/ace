module Focl.P061

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/61
Problem 61, Map Construction
Difficulty: easy
Write a function which takes a vector of keys 
and a vector of values and constructs a map from them.
    (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
    (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
    (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
*)

let la2, lb2, r2 =
    [ 1; 2; 3; 4 ], [ "one"; "two"; "three" ], [ (1, "one"); (2, "two"); (3, "three") ]

let f061a la lb =
    let n = ([ List.length la ] @ [ List.length lb ] |> List.min) - 1
    List.zip la[..n] lb[..n]

[<Fact>]
let t061a () = f061a la2 lb2 |> should equal r2

let f061b (a: 'a list) (b: 'b list) : Map<'a, 'b> =
    let rec f (acc: Map<'a, 'b>) (a: 'a list) (b: 'b list) =
        match a, b with
        | [], _ -> acc
        | _, [] -> acc
        | x :: xs, y :: ys -> f (acc.Add(x, y)) xs ys

    f Map.empty a b

[<Fact>]
let t061b () =
    let exp = Map.ofList [ (1, "one"); (2, "two"); (3, "three") ]
    f061b [ 1; 2; 3; 4 ] [ "one"; "two"; "three" ] |> should equal exp
