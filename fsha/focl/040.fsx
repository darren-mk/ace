(*
https://4clojure.oxal.org/#/problem/40
Problem 40, Interpose a Seq
Difficulty: easy
Write a function which separates the items of a sequence by an arbitrary value.
(= (__ 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
*)

let v1, l1, r1 = 
  0, [1; 2; 3], [1; 0; 2; 0; 3]

let rec f1 (v: int) (l: int list) =
  match l with
  | [] -> failwith "should not reach"
  | [x] -> [x]
  | x :: xs -> [x; v] @ (f1 v xs)
f1 v1 l1 = r1 // true