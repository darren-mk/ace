(*
https://4clojure.oxal.org/#/problem/54
Problem 54, Partition a Sequence
Difficulty: medium
Write a function which returns a sequence of lists of x items each. Lists of less than x items should not be returned.
    (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
    (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
    (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))
*)

let n1, l1 = 3, [0..8]

let f1 (n: int) (l: int list) =
  let f (acc: int list list) (x:int) =
    match acc with 
    | [] -> [[x]]
    | (existing: int list list) -> 
      let firstLvIndex: int = List.length existing
      let lastList: int list = existing[firstLvIndex - 1]
      let (targetIndex, targetValue) = 
        if List.length lastList < n
        then (firstLvIndex - 2, lastList @ [x])
        else (firstLvIndex - 1, lastList @ [x])
      acc[0..targetIndex] @ [targetValue]
  List.fold f [] l
f1 n1 l1
