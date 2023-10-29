(*
https://4clojure.oxal.org/#/problem/43
Problem 43, Reverse Interleave
Difficulty: medium
Write a function which reverses the interleave process into x number of subsequences.
(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
*)

let l1, n1, r1 = 
  [1; 2; 3; 4; 5; 6], 2, [[1; 3; 5]; [2; 4; 6]]
let l2, n2, r2 = 
  [0 .. 8], 3, [[0; 3; 6]; [1; 4; 7]; [2; 5; 8]]

let f1 (l: int list) (n: int) =
  let f (acc: Map<int, int list>) x = 
    let r: int = x % n
    let v: int list option = acc.TryFind r
    let v': int list = 
      match v with
      | Some existingV -> existingV @ [x]
      | None -> [x]
    acc.Add (r, v')
  let m: Map<int,int list> = List.fold f Map.empty l
  m.Values |> List.ofSeq |> List.sort 
f1 l1 n1 = r1 // true
f1 l2 n2 = r2 // true