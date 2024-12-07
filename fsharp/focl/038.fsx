(*
https://4clojure.oxal.org/#/problem/38
Problem 38, Maximum value
Difficulty: easy
Write a function which takes a variable number of parameters and returns the maximum value.
(= (__ 1 8 3 4) 8)
(= (__ 30 20) 30)
(= (__ 45 67 11) 67)
*)

let l1, r1 = [1; 8; 3; 4], 8
let l2, r2 = [30; 20], 30
let l3, r3 = [45; 67; 11], 67

let f1 l =
  let f mx x = if mx > x then mx else x
  List.fold f (List.head l) l
f1 l1 = r1 // true
f1 l2 = r2 // true
f1 l3 = r3 // true

let f2 l = List.sort >> List.last <| l
f2 l1 = r1 // true
f2 l2 = r2 // true
f2 l3 = r3 // true

let rec f3 l = 
  let f (a:int) (b:int) = if a > b then a else b
  match l with
  | [] -> failwith "should not reach"
  | [x] -> x
  | x :: xs -> f x (f3 xs)
f3 l1 = r1 // true
f3 l2 = r2 // true
f3 l3 = r3 // true