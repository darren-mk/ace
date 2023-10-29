(*
https://4clojure.oxal.org/#/problem/55
Problem 55, Count Occurences
Difficulty: medium
Write a function which returns a map containing 
the number of occurences of each distinct item in a sequence.
    (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
    (= (__ [:b :a :b :a :b]) {:a 2, :b 3})
    (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})
*)

let l1, r1 = 
  [1; 1; 2; 3; 2; 1; 1], Map.ofList [1, 4; 2, 2; 3, 1]

let f1 (l: int list) =
  let f (acc: Map<int,int>) (x: int) =
    match acc.TryFind x with
    | None -> acc.Add(x, 1)
    | Some (v: int) -> acc.Add(x, v + 1)
  List.fold f Map.empty l
f1 l1 = r1 // true