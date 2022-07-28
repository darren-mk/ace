// A
let rec mapA f l =
    match l with
    | [] -> []
    | x::xs -> f x :: mapA f xs   
mapA (fun x -> x * 10) [1; 2; 3] = [10; 20; 30] // true

// B
let mapB f l = List.fold (fun a x -> f x :: a) [] l 
mapB (fun x -> x * 10) [1; 2; 3] = [10; 20; 30] // true