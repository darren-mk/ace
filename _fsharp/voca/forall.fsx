// A
let rec forallA f l =
    match l with
    | [] -> true
    | x::xs -> f x && forallA f xs
forallA (fun x -> x < 4) [1; 2; 3] = true // true
forallA (fun x -> x < 4) [1; 2; 3; 4] = false // true

// B
let forallB f l = List.fold (fun a x -> f x && a) true l
forallB (fun x -> x < 4) [1; 2; 3] = true // true
forallB (fun x -> x < 4) [1; 2; 3; 4] = false // true