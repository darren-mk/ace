;; https://projecteuler.net/problem=1
;; Multiples of 3 or 5
;; Show HTML problem content
;; Problem 1
;; If we list all the natural numbers below 10 that are multiples of 3 or 5,
;; we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.

(defn divisible-by? [x n]
  (= 0 (mod x n)))

(defn divisible-by-3-or-5? [x]
  (or (divisible-by? x 3)
      (divisible-by? x 5)))

(->> (range 1000)
     (filter divisible-by-3-or-5?)
     (apply +))
;; => 233168