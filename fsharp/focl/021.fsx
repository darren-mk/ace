(* https://4clojure.oxal.org/#/problem/21
Problem 21
Write a function which returns the Nth element from a sequence.
(= (__ '(4 5 6 7) 2) 6)
(= (__ [:a :b :c] 0) :a)
(= (__ [1 2 3 4] 1) 2)
(= (__ '([1 2] [3 4] [5 6]) 2) [5 6]) *)

let x1, y1, r1 = [4; 5; 6; 7], 2, 6
let x2, y2, r2 = ['a'; 'b'; 'c'], 0, 'a'
let x3, y3, r3 = [1; 2; 3; 4], 1, 2
let x4, y4, r4 = [[1; 2]; [3; 4]; [5; 6]], 2, [5; 6]

// a
let fa x y =
    let c = List.length x
    let m = Seq.zip [0..c] x |> Map
    m.TryFind y
fa x1 y1 = Some r1 // true
fa x2 y2 = Some r2 // true
fa x3 y3 = Some r3 // true             
fa x4 y4 = Some r4 // true

// b
let fb (x : 'a list) (y : int) = x[y]
fb x1 y1 = r1 // true
fb x2 y2 = r2 // true
fb x3 y3 = r3 // true             
fb x4 y4 = r4 // true

let f3 l i = List.tryItem i l
f3 x1 y1 // Some 6
f3 x2 y2 // Some 'a'
f3 x3 y3 // Some 2       
f3 x4 y4 // Some [5; 6]

let rec f4 l i = 
    if i = 0 
    then List.tryHead l
    else f4 (List.tail l) (i - 1) 
f4 x1 y1 // Some 6
f4 x2 y2 // Some 'a'
f4 x3 y3 // Some 2       
f4 x4 y4 // Some [5; 6]
