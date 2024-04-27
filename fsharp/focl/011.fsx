// https://4clojure.oxal.org/#/problem/11

// When operating on a map, the conj function returns 
// a new map with one or more key-value pairs "added".

// (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))

let target = Map.ofList ["a", 1; "b", 2; "c", 3]
let starting = Map.ofList ["a", 1]
let endup = starting
              .Add("b", 2)
              .Add("c", 3)

endup.Equals target
// val it: bool = true