let factorial_iterative n =
    let mutable x = n
    let mutable v = 1
    while x > 0 do
        v <- v * x
        x <- x - 1
    v

factorial_iterative 5
// val it: int = 120

let rec factorial_recursive n =
    if n < 1 then 1
    else n * factorial_recursive (n - 1)

factorial_recursive 5
// val it: int = 120

let rec factorial_recursive_unsigned (n: uint32) =
    match n with
    | 0u | 1u -> 1u
    | _ -> n * factorial_recursive_unsigned (n - 1u)

factorial_recursive_unsigned 5u
// val it: uint32 = 120u

let factorial_folding n =
    let mult a b = a * b
    List.fold mult 1 [1 .. n] 

factorial_folding 5
// val it: int = 120

let factorial_reducing n =
    let mult a b = a * b
    List.reduce mult [1 .. n]

factorial_reducing 5
// val it: int = 120
