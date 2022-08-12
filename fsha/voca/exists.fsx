// A
let rec existsA f l =
    match l with
    | [] -> false
    | x::xs -> f x || existsA f xs
existsA (fun x -> x = 3) [1; 2; 3; 4; 5] = true // true
existsA (fun x -> x > 5) [1; 2; 3; 4; 5] = false // true

// B
let existsB f l = List.fold (fun acc x -> f x || acc) false l
existsB (fun x -> x = 3) [1; 2; 3; 4; 5] = true // true
existsB (fun x -> x > 5) [1; 2; 3; 4; 5] = false // true


[<Measure>] type m
[<Measure>] type sec
[<Measure>] type kg

let distance = 1.0<m>
let time = 2.0<sec>
let speed = distance/time
let acceleration = speed/time
let mass = 5.0<kg>
let force = mass * speed/time