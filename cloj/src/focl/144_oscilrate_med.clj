;; https://4clojure.oxal.org/#/problem/144

;; 1
(defn f1 [v & fs]
  ())

(= (take 3 (f1 3.14 int double)) [3.14 3 3.0])
(= (take 5 (f1 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])
(= (take 12 (f1 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])
