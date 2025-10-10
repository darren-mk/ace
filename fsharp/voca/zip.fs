module Voca.Zip

open Xunit
open FsUnit.Xunit

let list_zip_a a b =

    let rec f acc x y =
        match (x, y) with
        | [], _ -> acc
        | _, [] -> acc
        | x :: xs, y :: ys ->
            let acc' = acc @ [ (x, y) ]
            f acc' xs ys

    f [] a b

[<Fact>]
let ``list_zip_a success cases`` () =
    list_zip_a [ 1; 2; 3; 4 ] [ 11; 12; 13; 14 ]
    |> should equal [ (1, 11); (2, 12); (3, 13); (4, 14) ]
