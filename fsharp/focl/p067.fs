module Focl.P067

open Xunit
open FsUnit.Xunit

(*
https://4clojure.oxal.org/#/problem/67
Problem 67, Prime Numbers
Difficulty: medium
Write a function which returns the first
x number of prime numbers.
    (= (__ 2) [2 3])
    (= (__ 5) [2 3 5 7 11])
    (= (last (__ 100)) 541)
*)

let isNotDivisible (dividee: int) (divisor: int) = dividee % divisor <> 0

let isPrime n =
    let f x =
        if isNotDivisible n x then false else true

    List.map f [ 2 .. (n - 1) ] |> List.contains true |> not

let generatePrimes n =
    let rec f i primes =
        if List.length primes = n then primes
        else if isPrime i then f (i + 1) (primes @ [ i ])
        else f (i + 1) primes

    f 2 []

//generatePrimes 2 = [ 2; 3 ] // true
//generatePrimes 5 = [ 2; 3; 5; 7; 11 ] // true
