(* https://4clojure.oxal.org/#/problem/23
Problem 23
Write a function which reverses a sequence.
(= (__ [1 2 3 4 5]) [5 4 3 2 1])
(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
Special Restrictions : reverse *)


let v1, r1 = [1; 2; 3; 4; 5], [5; 4; 3; 2; 1]
let v2, r2 = [2; 5; 7], [7; 5; 2]
let v3, r3 = [[1; 2]; [3; 4]; [5; 6]], [[5; 6]; [3; 4]; [1; 2]]

// A
let rec fA l =
    match l with
    | [] -> []
    | (x::xs) -> (fA xs) @ [x]
fA v1 = r1 // true
fA v2 = r2 // true
fA v3 = r3 // true


// B
let fB l = List.rev l
fB v1 = r1 // true
fB v2 = r2 // true
fB v3 = r3 // true

// C
let rec fC l = List.fold (fun acc x -> acc @ [x]) [] l
fC v1 = r1 // true
fC v2 = r2 // true
fC v3 = r3 // true