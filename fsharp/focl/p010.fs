module Focl.P010

// https://4clojure.oxal.org/#/problem/10

// Maps store key-value pairs.
// Both maps and keywords can be used as lookup functions.
// Commas are whitespace.
//(= __ ((hash-map :a 10, :b 20, :c 30) :b))
//(= __ (:b {:a 10, :b 20, :c 30}))

open Xunit
open FsUnit.Xunit

[<Fact>]
let test_p010_a () =
    let v = Map.ofList [ "a", 10; "b", 20; "c", 30 ]
    v["b"] |> should equal 20
