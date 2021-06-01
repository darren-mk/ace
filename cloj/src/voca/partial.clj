(def add-hundred (partial + 100))
;; => #'focl.core/add-hundred

(add-hundred 1)
;; => 101 

(add-hundred 1 2 3)
;; => 106 

(+ 100 1 2 3)
;; => 106

(def add-some-and (partial + 1 2 3))
;; => #'user/add-some-and

(add-some-and 4 5)
;; => 15

(def one-over (partial / 1))
;; => #'user/one-over

(one-over 2)
;; => 1/2

(map (partial / 1) [1 2 3 4 5])
;; => (1 1/2 1/3 1/4 1/5)


;;;; implementation

(defn partial-2 [f & xs]
  (fn [& ys]
    (apply f (concat xs ys))))

((partial-2 + 101 202) 1 2 3 4 5)
;; => 318
