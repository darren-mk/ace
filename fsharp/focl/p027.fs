module Focl.P027

(* 
https://4clojure.oxal.org/#/problem/27
Problem 27
Write a function which returns true if the given sequence is a palindrome.
Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(false? (__ '(1 2 3 4 5)))
(true? (__ "racecar"))
(true? (__ [:foo :bar :foo]))
(true? (__ '(1 1 3 3 1 1)))
(false? (__ '(:a :b :c))) 
*)


// A
let palindrome_a l = (List.rev l) = l
