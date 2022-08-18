;; https://4clojure.oxal.org/#/problem/158

;; 1
(defn f1 [f] 

  )
(= 10 ((f1 (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (+ a b c d))))))
       1 2 3 4))
(= 24 ((f1 (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (* a b c d))))))
       1 2 3 4))
(= 25 ((f1 (fn [a]
             (fn [b]
               (* a b))))
       5 5))
