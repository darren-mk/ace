module Voca.Tail

open Xunit
open FsUnit.Xunit

[<Fact>]
let built_in_basics () =
    [ 10; 20; 30; 40 ].Tail |> should equal [ 20; 30; 40 ]
    List.tail [ 1; 2; 3 ] |> should equal [ 2; 3 ]

let tail_a l =
    match l with
    | [] -> []
    | [ _x ] -> []
    | _x :: xs -> xs

[<Fact>]
let test_tail_a () =
    tail_a [ 10; 20; 30; 40 ] |> should equal [ 20; 30; 40 ]
    tail_a [ 1; 2; 3 ] |> should equal [ 2; 3 ]
