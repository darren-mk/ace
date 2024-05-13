(*
https://4clojure.oxal.org/#/problem/45
Problem 45, Intro to Iterate
Difficulty: easy
The iterate function can be used to produce an infinite lazy sequence.
    (= __ (take 5 (iterate #(+ 3 %) 1)))
*)