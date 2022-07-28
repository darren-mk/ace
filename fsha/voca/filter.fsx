// A
let rec filterA f l =
    match l with
    | [] -> []
    | x::xs ->
        if f x
        then x :: filterA f xs
        else filterA f xs
filterA (fun x -> x % 2 = 0) [1; 2; 3; 4; 5]
    //= [2; 4] // true

// B
let rec filterB f l = List.fold (fun a x -> if f x then a @ [x] else a) [] l
filterB (fun x -> x % 2 = 0) [1; 2; 3; 4; 5] = [2; 4] // true