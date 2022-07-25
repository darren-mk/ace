(* https://4clojure.oxal.org/#/problem/19
Problem 19
Write a function which returns the last element in a sequence.
(= (__ [1 2 3 4 5]) 5)
(= (__ '(5 4 3)) 3)
(= (__ ["b" "c" "d"]) "d")
Special Restrictions : last *)

let v1 = [1; 2; 3; 4; 5]
let v2 = [5; 4; 3]
let v3 = ['b'; 'c'; 'd']

// 1
let rec f1 l =
    match l with
    | [] -> None
    | [x] -> Some x
    | (x::xs) -> f1 xs
f1 v1 = Some 5 // true
f1 v2 = Some 3 // true
f1 v3 = Some 'd' // true

// 2
let f2 l = List.rev >> List.head <| l
f2 v1 = 5 // true
f2 v2 = 3 // true
f2 v3 = 'd' // true