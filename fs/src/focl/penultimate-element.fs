// https://www.4clojure.com/problem/20

// 1
let f1 l =
    l |> List.rev |> List.tail |> List.head
f1 [1; 2; 3; 4; 5;] = 4 // true
f1 ["a"; "b"; "c";] = "b" // true
f1 [[1; 2;]; [3; 4;];] = [1; 2;] // true
