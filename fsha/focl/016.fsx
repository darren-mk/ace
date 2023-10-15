// https://4clojure.oxal.org/#/problem/16

(*
Problem 16, Hello World
Difficulty: elementary
Write a function which returns a personalized greeting.
(= (__ "Dave") "Hello, Dave!")
(= (__ "Jenn") "Hello, Jenn!")
(= (__ "Rhea") "Hello, Rhea!")
*)

let f1 nm = printfn "Hello, %s!" nm
f1 "Dave" // Hello, Dave!
f1 "Jenn" // Hello, Jenn!
f1 "Rhea" // Hello, Rhea!