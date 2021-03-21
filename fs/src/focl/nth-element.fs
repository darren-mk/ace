// https://www.4clojure.com/problem/21

// 1
let f1 l n =
    List.item n l
f1 [4; 5; 6; 7;] 2 = 6 // true
f1 ["a"; "b"; "c";] 0 = "a" // true
f1 [1; 2; 3; 4;] 1 = 2 // true
f1 [[1; 2;]; [3; 4;]; [5; 6;];] 2 = [5; 6;] // true
