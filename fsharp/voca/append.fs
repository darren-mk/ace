module append

open Xunit
open FsUnit.Xunit

[<Fact>]
let append_list () =
    List.append [ 1; 2; 3 ] [ 4; 5; 6 ]
    |> should equal [ 1; 2; 3; 4; 5; 6 ]

[<Fact>]
let append_seq () =
    let a = seq { 1..2 }
    let b = seq { 100..103 }
    Seq.append a b
    |> should equalSeq (seq [ 1; 2; 100; 101; 102; 103 ])
