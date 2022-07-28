// A
let maxA l = List.reduce (fun a x -> if a < x then x else a) l
maxA [1; 2; 3; 4; 5] = 5 // true