(use 'clojure.walk)
;; => nil

(walk #(* 2 %) #(apply + %) [1 2 3 4 5])
;; => 30

(walk #(- % 1) #(apply + %) [1 2 3 4 5])
;; => 10
