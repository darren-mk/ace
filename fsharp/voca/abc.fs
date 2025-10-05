module abc

open Xunit
open FsUnit.Xunit

let add x y = x + y

[<Fact>]
let ``add adds two ints (FsUnit)`` () =
    add 1 2 |> should equal 3
