module Voca.Infix

open Xunit
open FsUnit.Xunit

let (<++>) = fun a b -> a + b

[<Fact>]
let ``adding infix success cases`` () =
    1 <++> 2 |> should equal 3
    1 <++> 2 <++> 3 |> should equal 6
