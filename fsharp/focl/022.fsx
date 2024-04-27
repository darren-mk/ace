(* https://4clojure.oxal.org/#/problem/22
Problem 22
Write a function which returns the total number of elements in a sequence.
(= (__ '(1 2 3 3 1)) 5)
(= (__ "Hello World") 11)
(= (__ [[1 2] [3 4] [5 6]]) 3)
(= (__ '(13)) 1)
(= (__ '(:a :b :c)) 3) *)

let v1, r1 = [1; 2; 3; 3; 1], 5
let v2, r2 = Seq.toList "Hello World", 11
let v3, r3 = [[1; 2]; [3; 4]; [5; 6]], 3
let v4, r4 = [13], 1
let v5, r5 = ['a'; 'b'; 'c'], 3

// a
let rec fA l = 
    match l with
    | [] -> 0
    | (x::xs) -> 1 + (fA xs)
fA v1 = r1 // true
fA v2 = r2 // true
fA v3 = r3 // true
fA v4 = r4 // true
fA v5 = r5 // true

// b
let rec fB l = List.length l    
fB v1 = r1 // true
fB v2 = r2 // true
fB v3 = r3 // true
fB v4 = r4 // true
fB v5 = r5 // true

// c
let rec fC l =
    List.fold (fun acc _ -> acc + 1) 0 l
fC v1 = r1 // true
fC v2 = r2 // true
fC v3 = r3 // true
fC v4 = r4 // true
fC v5 = r5 // true

// d
let rec fD l =
    l
    |> List.map (fun _ -> 1)
    |> List.sum
fD v1 = r1 // true
fD v2 = r2 // true
fD v3 = r3 // true
fD v4 = r4 // true
fD v5 = r5 // true

// e
let rec fE l =
    seq { for x in l do 1 }
    |> Seq.toList
    |> List.sum    
fE v1 = r1 // true
fE v2 = r2 // true
fE v3 = r3 // true
fE v4 = r4 // true
fE v5 = r5 // true

let f6 = List.length
f6 v1 = r1 // true
f6 v2 = r2 // true
f6 v3 = r3 // true
f6 v4 = r4 // true
f6 v5 = r5 // true

let f7 (l: 'a list) =
    let rec f y (n:int) =
        match y with 
        | [] -> n
        | (x::tail) -> f tail (n + 1)
    f l 0
f7 v1 = r1 // true
f7 v2 = r2 // true
f7 v3 = r3 // true
f7 v4 = r4 // true
f7 v5 = r5 // true

let rec f8 l =
    match l with
    | [] -> 0
    | (_::tail) -> 1 + (f8 tail)
f8 v1 = r1 // true
f8 v2 = r2 // true
f8 v3 = r3 // true
f8 v4 = r4 // true
f8 v5 = r5 // true

let f9 l = 
    List.fold (fun acc item -> acc + 1) 0 l
f9 v1 = r1 // true
f9 v2 = r2 // true
f9 v3 = r3 // true
f9 v4 = r4 // true
f9 v5 = r5 // true