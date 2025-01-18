let rec fibonacci n =
    match n with
        | 0 | 1 -> n 
        | _ -> (fibonacci (n - 1)) + (fibonacci (n - 2))

fibonacci 10
// val it: int = 55

// do with caching
