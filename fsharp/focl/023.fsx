(* https://4clojure.oxal.org/#/problem/23
Problem 23
Write a function which reverses a sequence.
(= (__ [1 2 3 4 5]) [5 4 3 2 1])
(= (__ (sorted-set 5 7 2 7)) '(7 5 2))
(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
Special Restrictions : reverse *)

let (v1: int list), (r1: int list) = [1; 2; 3; 4; 5], [5; 4; 3; 2; 1]
let (v2: int list), (r2: int list) = [2; 5; 7], [7; 5; 2]
let (v3: int list list), (r3: int list list) = 
    [[1; 2]; [3; 4]; [5; 6]], [[5; 6]; [3; 4]; [1; 2]]

// A
let rec fA (l: 'a list) =
    match l with
    | [] -> []
    | ((x: 'a)::(xs: 'a list)) -> (fA xs) @ [x] ;;
fA v1 = r1 ;; // true
fA v2 = r2 ;; // true
fA v3 = r3 ;; // true


// B
let fB l = List.rev l
fB v1 = r1 // true
fB v2 = r2 // true
fB v3 = r3 // true

// C
let rec fC (l: 'a list) = 
    List.fold (fun (acc: 'a list) (x: 'a) -> [x] @ acc) [] l;;
fC v1 = r1 ;; // true
fC v2 = r2 ;; // true
fC v3 = r3 ;; // true

let rec f4 l =
    match l with
    | [] -> []
    | (x::xs) -> (f4 xs) @ [x]
f4 v1 = r1 ;; // true
f4 v2 = r2 ;; // true
f4 v3 = r3 ;; // true

let f5 l =
    let f = (fun (acc: 'a list) (x: 'a) -> [x] @ acc)
    List.fold f [] l
f5 v1 = r1 // true
f5 v2 = r2 // true
f5 v3 = r3 // true