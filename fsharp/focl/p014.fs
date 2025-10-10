module Focl.P014

// https://4clojure.oxal.org/#/problem/14

(*
Problem 14, Functions
Difficulty: elementary
Clojure has many different ways to create functions.
(= __ ((fn add-five [x] (+ x 5)) 3))
(= __ ((fn [x] (+ x 5)) 3))
(= __ (#(+ % 5) 3))
(= __ ((partial + 5) 3))
*)
