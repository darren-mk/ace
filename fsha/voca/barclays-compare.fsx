let rec fib x =
    printfn "calculated: %i" x
    match x with
    | 1 | 2 | 3 -> x
    | _ -> fib (x - 1) + fib (x - 2)


fib 10
































(*
let rec getLastIndex f limit i =
    let test = f i < limit && limit < f (i + 1)
    if test
    then i
    else getLastIndex f limit (i + 1)

let findLastIndex f limit = getLastIndex f limit 1

let answer =
    let lastIndex = findLastIndex fib 4000000
    List.map fib [1..lastIndex]
    |> List.filter (fun x -> x % 2 = 0)
    |> List.sum

// val answer: int = 4613732
*)
