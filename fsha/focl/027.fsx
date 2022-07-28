(* https://4clojure.oxal.org/#/problem/27
Problem 27
Write a function which returns true if the given sequence is a palindrome.
Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(false? (__ '(1 2 3 4 5)))
(true? (__ "racecar"))
(true? (__ [:foo :bar :foo]))
(true? (__ '(1 1 3 3 1 1)))
(false? (__ '(:a :b :c))) *)

let v1 = [1; 2; 3; 4; 5]
let v2 = Array.toList <| "racecar".ToCharArray()
let v3 = ["foo"; "bar"; "foo"]
let v4 = [1; 1; 3; 3; 1; 1]
let v5 = ['a'; 'b'; 'c']

// A
let fA l =
    let r = List.rev l
    r = l
fA v1 = false // true
fA v2 = true // true
fA v3 = true // true
fA v4 = true // true
fA v5 = false // true