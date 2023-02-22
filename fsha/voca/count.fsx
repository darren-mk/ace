// 1
let rec count1 l =
    match l with
    | [] -> 0
    | x::xs -> 1 + count1 xs
count1 [1; 2; 3; 4] = 4 // true

// 2
let lfold = List.fold
let count2 l = lfold (fun acc x -> acc + 1) 0 l
count2 [1; 2; 3; 4] = 4 // true

// 3
let lmap = List.map
let count3 l = lmap (fun _ -> 1) l |> List.sum
count3 [1; 2; 3; 4] = 4 // true
