(*
https://4clojure.oxal.org/#/problem/29
Problem 29, Get the Caps
Difficulty: easy
Write a function which takes a string and returns 
a new string containing only the capital letters.
*)

let v1, r1 = "HeLlO, WoRlD!", "HLOWRD"
let v2, r2 = "nothing", ""
let v3, r3 = "$#A(*&987Zf", "AZ"

let f1 (s:string) =
  Array.filter System.Char.IsUpper (s.ToCharArray())
  |> System.String
f1 v1 = r1 // true
f1 v2 = r2 // true
f1 v3 = r3 // true