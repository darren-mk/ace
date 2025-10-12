module Focl.P016

open Xunit
open FsUnit.Xunit

// https://4clojure.oxal.org/#/problem/16
(*
Problem 16, Hello World
Difficulty: elementary
Write a function which returns a personalized greeting.
(= (__ "Dave") "Hello, Dave!")
(= (__ "Jenn") "Hello, Jenn!")
(= (__ "Rhea") "Hello, Rhea!")
*)

let f_p016_a s = "Hello, " + s + "!"

[<Fact>]
let test_p016_a () =
    f_p016_a "Dave" |> should equal "Hello, Dave!"
    f_p016_a "Jenn" |> should equal "Hello, Jenn!"
    f_p016_a "Rhea" |> should equal "Hello, Rhea!"
