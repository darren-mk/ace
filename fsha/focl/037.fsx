(*
https://4clojure.oxal.org/#/problem/37
Problem 37, Regular Expressions
Difficulty: elementary
Regex patterns are supported with a special reader macro.
(= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
*)