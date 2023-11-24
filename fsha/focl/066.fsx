(*
https://4clojure.oxal.org/#/problem/66
Problem 66, Greatest Common Divisor
Difficulty: easy
Given two integers, write a function which
returns the greatest common divisor.
    (= (__ 2 4) 2)
    (= (__ 10 5) 5)
    (= (__ 5 7) 1)
    (= (__ 1023 858) 33)
*)

let f1 a b =
  let isDivisible dividee divisor = dividee % divisor = 0
  let isBothDibisible x = isDivisible a x && isDivisible b x
  let smaller = List.min [a; b]
  let f greatest candidate =
    if isBothDibisible candidate then candidate else greatest
  List.fold f 1 [1..smaller]
f1 2 4 = 2 // true
f1 10 5 = 5 // true
f1 5 7 = 1 // true
f1 1023 858 = 33 // true
