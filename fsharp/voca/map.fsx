// A
let rec mapA f l =
    match l with
    | [] -> []
    | x::xs -> f x :: mapA f xs
mapA (fun x -> x * 10) [1; 2; 3] = [10; 20; 30] // true

List.map (fun x -> x + 5) [1; 2; 3] // [6; 7; 8]
Seq.map (fun x -> x + 5) [1 .. 3] // seq [6; 7; 8]
Array.map (fun x -> x + 5) [| 1; 2; 3 |] // [|6; 7; 8|]