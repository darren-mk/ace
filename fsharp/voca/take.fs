module Voca.Take

open Xunit
open FsUnit.Xunit

let take_a (n: int) (sq: seq<'a>) =
    let rec f (n: int) (l: 'a list) =
        if n = 0 then
            []
        else
            [ List.head l ] @ f (n - 1) (List.tail l)

    f n (List.ofSeq sq) |> Seq.ofList

[<Fact>]
let test_take_a () =
    take_a 3 (seq { 1..100 }) |> should equalSeq [ 1; 2; 3 ]
