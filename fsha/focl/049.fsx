(*
https://4clojure.oxal.org/#/problem/49
Problem 49, Split a sequence
Difficulty: easy
Write a function which will split a sequence into two parts.
    (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
    (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
    (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])
*)

let n1, l1, r1 = 
  3, [1..6], [[1..3]; [4..6]]
let n2, l2, r2 = 
  1, ["a"; "b"; "c" ;"d"], [["a"]; ["b"; "c"; "d"]]
let n3, l3, r3 =
  2, [[1; 2]; [3; 4]; [5; 6]], [[[1; 2]; [3; 4]]; [[5; 6]]]


let f1 (n: int) (l: 'a list) =
  [l[0..(n-1)];  l[n..]]
f1 n1 l1 = r1 // true
f1 n2 l2 = r2 // true
f1 n3 l3 = r3 // true