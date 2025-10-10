module Fffp.UnderstandingMapAndApply

open Xunit
open FsUnit.Xunit

// http://fsharpforfunandprofit.com/posts/elevated-world/#map

let addOne x = x + 1

let map_option f a =
    match a with
    | Some x -> Some(f x)
    | None -> None

[<Fact>]
let ``map_option success cases`` () =
    Some 1 |> map_option addOne |> should equal (Some 2)

let rec map_list f l =
    match l with
    | [] -> []
    | x :: xs -> f x :: map_list f xs

[<Fact>]
let ``map_list success cases`` () =
    map_list addOne [ 1; 2; 3 ] |> should equal [ 2; 3; 4 ]

// https://fsharpforfunandprofit.com/posts/elevated-world/#the-return-function

let return_option x = Some x

[<Fact>]
let ``return_option success cases`` () =
    return_option 1 |> should equal (Some 1)

let return_list x = [ x ]

[<Fact>]
let ``return_list success cases`` () = return_list 1 |> should equal [ 1 ]

// https://fsharpforfunandprofit.com/posts/elevated-world/#the-apply-function
