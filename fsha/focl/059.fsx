(*
https://4clojure.oxal.org/#/problem/59
Problem 59, Juxtaposition
Difficulty: medium
Take a set of functions and return a new function that takes a variable 
number of arguments and returns a sequence containing the result of 
applying each function left-to-right to the argument list.
    (= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
    (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
    (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
*)

let f1 fa fb fc =
  fun x -> 
    let a = fa x
    let b = fb x
    let c = fc x
    [a; b; c]
f1 List.sum List.max List.min <| [2; 3; 5; 1; 6; 4] // [21; 6; 1]