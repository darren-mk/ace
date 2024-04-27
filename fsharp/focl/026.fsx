(* 
https://4clojure.oxal.org/#/problem/26
Problem 26
Write a function which returns the first X fibonacci numbers.
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21)) 
*)

// A
open System.Collections.Generic

let caching = Dictionary<int, int>()
let memoize f =
    fun x ->
        let existence, value = caching.TryGetValue x
        if existence
        then value
        else let v = f x
             caching.Add(x, v)
             v
let rec fib x =
    match x with
    | 1 | 2 | 3 -> x
    | _ -> fib (x - 1) + fib (x - 2)
fib 1 = 1 // true
fib 2 = 2 // true
fib 4 = 5 // true
fib 9 = 55 // true
fib 10 = 89 // true 
let fibMemoized = memoize fib
fibMemoized 1 = 1 // true
fibMemoized 3 = 3 // true
fibMemoized 5 = 8 // true
fibMemoized 9 = 55 // true
fibMemoized 10 = 89 // true