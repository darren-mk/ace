// A
let rec countA l =
    match l with
    | [] -> 0
    | (x::xs) -> 1 + countA xs
countA [1; 2; 3; 4] = 4 // true

// B
let countB l = List.fold (fun acc x -> acc + 1) 0 l
countB [1; 2; 3; 4] = 4 // true

// C
let countC l = List.map (fun _ -> 1) l |> List.sum
countC [1; 2; 3; 4] = 4 // true


