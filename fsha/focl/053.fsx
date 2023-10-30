(*
https://4clojure.oxal.org/#/problem/53
Problem 53, Longest Increasing Sub-Seq
Difficulty: hard
Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.
    (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
    (= (__ [5 6 1 3 2 7]) [5 6])
    (= (__ [2 3 3 4 5]) [3 4 5])
    (= (__ [7 6 5 4]) [])
*)

let l1, r1 = [1; 0; 1; 2; 3; 0; 4; 5], [0; 1; 2; 3]
let l2, r2 = [5; 6; 1; 3; 2; 7], [5; 6]
let l3, r3 = [2; 3; 3; 4; 5], [3; 4; 5]
let l4, r4 = [7; 6; 5; 4], []

type Inner =
  { longest : int list 
    candidate : int list }
let f1 (l: int list) =
  let f (acc: Inner) x =
    let candidate': int list = 
      match acc.candidate with 
      | [] -> [x]
      | existing -> 
        if (List.last existing) + 1 = x 
        then acc.candidate @ [x] 
        else [x]
    let longest': int list =
      if List.length acc.longest > List.length candidate'
      then acc.longest else candidate'
    { candidate = candidate'; longest = longest' }
  let calc = List.fold f { longest = [] ; candidate = [] } l
  match calc.longest with
  | [] -> []
  | [x] -> []
  | xs -> xs
f1 l1 = r1 // true
f1 l2 = r2 // true
f1 l3 = r3 // true
f1 l4 = r4 // true
