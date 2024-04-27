;; https://4clojure.oxal.org/#/problem/137

;; 1
(defn f1 [n b]
  (loop [n n
         l []]
    (if (< n b) (cons n l)
        (let [r (rem n b)
              q (quot (- n r) b)]
          (recur q (cons r l))))))
(= [1 2 3 4 5 0 1] (f1 1234501 10)) ;; => true
(= [0] (f1 0 11)) ;; => true
(= [1 0 0 1] (f1 9 2)) ;; => true
(= [1 0] (let [n (rand-int 100000)] (f1 n n))) ;; => true
;; (= [22 6 10 5 0 19 6 9 6 31] (f1 js/Number.MAX_SAFE_INTEGER 42))

