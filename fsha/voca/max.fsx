// 1
let max1 l = List.reduce (fun a x -> if a < x then x else a) l
max1 [1; 2; 3; 4; 5] = 5 // true

// b
let max2 (l: 'a list) =
    let rec f (m: 'b) (l: 'b list) =
        let h: 'b = List.head l
        let t: 'b list = List.tail l
        match l with
        | [] -> m
        | _ -> if m > h
               then f m t
               else f h t
    f (List.head l) (List.tail l)
max1 [1; 2; 3; 4; 5] = 5 // true

// 3
let rec max3 l =
    let larger a b =
        match a, b with
        | (_, None) -> a
        | (_, _) -> if a > b then a else b
    match l with
    | [] -> None
    | head::tail -> larger head (max3 tail)
max3 [Some 1; Some 2; Some 3]
