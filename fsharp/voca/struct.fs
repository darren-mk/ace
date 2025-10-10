module Voca.Struct

open Xunit
open FsUnit.Xunit

[<Struct>]
type Point = { x: float; y: float }

[<Fact>]
let test_point_struct () =
    let p = { x = 1.1; y = 2.2 }
    p.x |> should equal 1.1
    p.y |> should equal 2.2
