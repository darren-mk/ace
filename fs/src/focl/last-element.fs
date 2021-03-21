// https://www.4clojure.com/problem/19

// 1
let f1 l =
    l |> List.rev |> List.head
f1 [1; 2; 3; 4; 5] = 5 // true
f1 [5; 4; 3] = 3 // true
f1 ["b"; "c"; "d"] = "d" // true

