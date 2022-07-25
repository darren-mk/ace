(* https://4clojure.oxal.org/#/problem/20
Problem 20
Write a function which returns the second to last element from a sequence.
(= (__ (list 1 2 3 4 5)) 4)
(= (__ ["a" "b" "c"]) "b")
(= (__ [[1 2] [3 4]]) [1 2]) *)

let v1, a1 = [1; 2; 3; 4; 5], 4
let v2, a2 = ['a'; 'b'; 'c'], 'b'
let v3, a3 = [[1; 2]; [3; 4]], [1; 2]

// a
let fa l = l |> List.rev |> List.tail |> List.head
fa v1 = a1 // true
fa v2 = a2 // true
fa v3 = a3 // true

let fb l =
    let m = Seq.zip [0..(List.length l)] (List.rev l) |> Map
    m.TryFind 1 
fb v1 = Some a1 // true
fb v2 = Some a2 // true
fb v3 = Some a3 // true