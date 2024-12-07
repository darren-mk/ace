;; https://4clojure.oxal.org/#/problem/37

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
:=> true
