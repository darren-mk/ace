let a = seq { 1 .. 2 }
let b = seq { 100 .. 103 }
Seq.append a b 
// seq [1; 2; 100; 101; ...]

List.append [1;2;3] [4;5;6]
// val it: int list = [1; 2; 3; 4; 5; 6]