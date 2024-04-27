(*
https://4clojure.oxal.org/#/problem/61
Problem 61, Map Construction
Difficulty: easy
Write a function which takes a vector of keys 
and a vector of values and constructs a map from them.
    (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
    (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
    (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
*)

let la2, lb2, r2 =
  [1; 2; 3; 4], ["one"; "two"; "three"], [(1, "one"); (2, "two"); (3, "three")]
let f1 la lb =
  let n = ([List.length la] @ [List.length lb] |> List.min) - 1
  List.zip la[..n] lb[..n]
f1 la2 lb2 = r2 // true