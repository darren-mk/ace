module Focl.P008

open Xunit
open FsUnit.Xunit

// https://4clojure.oxal.org/#/problem/8

let v: Set<string> = Set.ofList [ "a"; "a"; "b"; "c"; "c"; "c"; "c"; "d"; "d" ]

[<Fact>]
let test_p008_a () =
    v |> should equal (set [ "a"; "b"; "c"; "d" ])
