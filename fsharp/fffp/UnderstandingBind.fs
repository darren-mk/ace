module Fffp.UnderstandingBind

open Xunit
open FsUnit.Xunit

module Option =
    let bind f x_opt =
        match x_opt with
        | Some v -> f v
        | _ -> None

let parse_int s =
    match s with
    | "-1" -> Some -1
    | "0" -> Some 0
    | "1" -> Some 1
    | "2" -> Some 2
    | _ -> None

[<Fact>]
let ``bind impl with parse_int success cases`` () =
    Option.bind parse_int None |> should equal None
    Option.bind parse_int (Some "1") |> should equal (Some 1)

type OrderQuantity = OrderQuantity of int

let to_order_quantity (q: int) : OrderQuantity option =
    if q >= 1 then Some(OrderQuantity q) else None

let parse_order_quantity (s: string) =
    parse_int s |> Option.bind to_order_quantity

[<Fact>]
let ``bind parsing order quantity`` () =
    parse_order_quantity "2" |> should equal (Some(OrderQuantity 2))

let (=>>>) x f = Option.bind f x

let parse_order_quantity_using_infix (s: string) = s |> parse_int =>>> to_order_quantity

[<Fact>]
let ``bind parsing order quantity infix`` () =
    parse_order_quantity_using_infix "2" |> should equal (Some(OrderQuantity 2))
