module Focl.P007

open Xunit
open FsUnit.Xunit

// https://4clojure.oxal.org/#/problem/7

[<Fact>]
let t1 () =
    let v1 = [ 1; 2; 3; 4 ]
    v1 |> should equal ([ 1; 2; 3 ] @ [ 4 ])
    v1 |> should equal ([ 1; 2; 3 ] @ [ 4 ])
