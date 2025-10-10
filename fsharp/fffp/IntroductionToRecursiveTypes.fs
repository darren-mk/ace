module Fffp.IntroductionToRecursiveTypes.fs

open Xunit
open FsUnit.Xunit

// https://fsharpforfunandprofit.com/posts/recursive-types-and-folds/#a-basic-recursive-type

type Book = { title: string; price: decimal }

type ChocolateType =
    | Dark
    | Milk
    | SeventyPercent

type Chocolate =
    { chocType: ChocolateType
      price: decimal }

type WrappingPaperStyle =
    | SingleLayer
    | DoubleLayer
    | TripleLayer

type Gift =
    | Book of Book
    | Chocolate of Chocolate
    | Wrapped of Gift * WrappingPaperStyle
    | Boxed of Gift
    | WithACard of Gift * message: string

let wolfHall = { title = "Wolf Hall"; price = 20m }

let yummyChoc =
    { chocType = SeventyPercent
      price = 5m }

let inside = Book wolfHall

let middle = Wrapped(inside, DoubleLayer)

let outside = WithACard(middle, message = "hoho")

let rec describe gift : string =
    match gift with
    | Book book -> "the book's title is " + book.title
    | Chocolate chocolate -> "the chocolate's price is " + chocolate.price.ToString()
    | Wrapped(gift, paper) -> "wrapped with " + paper.ToString() + " " + describe gift
    | Boxed innerGift -> "in a box " + (describe innerGift)
    | WithACard(innerGift, message) -> "with a card saying " + (describe innerGift) + message

let rec total_cost gift : decimal =
    match gift with
    | Book book -> book.price
    | Chocolate chocolate -> chocolate.price
    | Wrapped(inner_gift, _paper) -> (total_cost inner_gift) + 0.5m
    | Boxed inner_gift -> (total_cost inner_gift) + 1.0m
    | WithACard(inner_gift, _message) -> (total_cost inner_gift) + 2.0m

[<Fact>]
let ``randome success cases for total_cost`` () =
    total_cost outside |> should equal 22.5m
