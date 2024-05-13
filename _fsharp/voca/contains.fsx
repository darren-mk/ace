// A    
let containsA v l = List.fold (fun a x -> v = x || a) false l
containsA 3 [1; 2; 3; 4; 5] = true
containsA 6 [1; 2; 3; 4; 5] = false

let rec containsB v l =
    match l with
    | [] -> false
    | x::xs -> v = x || containsB v xs
containsB 3 [1; 2; 3; 4; 5] = true
containsB 6 [1; 2; 3; 4; 5] = false