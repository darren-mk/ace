module Focl.P051

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/51
Problem 51, Advanced Destructuring
Difficulty: easy
Here is an example of some more sophisticated destructuring.
    (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
*)

[<Fact>]
let test_p051_a () =
    let (a, b, (x, y, z), d) = (1, 2, (3, 4, 5), [ 1; 2; 3; 4; 5 ])
    a |> should equal 1
    b |> should equal 2
    x |> should equal 3
    y |> should equal 4
    z |> should equal 5
    d |> should equal [ 1; 2; 3; 4; 5 ]
