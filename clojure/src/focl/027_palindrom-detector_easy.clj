;; https://4clojure.oxal.org/#/problem/27

;; Problem 27
;; Write a function which returns true if the given sequence is a palindrome.
;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
;; (false? (__ '(1 2 3 4 5)))
;; (true? (__ "racecar"))
;; (true? (__ [:foo :bar :foo]))
;; (true? (__ '(1 1 3 3 1 1)))
;; (false? (__ '(:a :b :c)))

;; 1
(defn f1 [seq]
  (let [r (if (string? seq)
            (clojure.string/join (reverse seq))
            (reverse seq))]
    (if (= seq r)
      true
      false)))
(false? (f1 '(1 2 3 4 5))) ;; => true
(true? (f1 "racecar")) ;; => true
(true? (f1 [:foo :bar :foo])) ;; => true
(true? (f1 '(1 1 3 3 1 1))) ;; => true
(false? (f1 '(:a :b :c))) ;; => true

;; 2
(defn f2 [coll]
  (as-> coll t
    (reverse t) 
      (= coll t)))
(false? (f2 '(1 2 3 4 5))) ;; => true
(true? (f2 "racecar")) ;; => false
(true? (f2 [:foo :bar :foo])) ;; => true
(true? (f2 '(1 1 3 3 1 1))) ;; => true
(false? (f2 '(:a :b :c))) ;; => true

;; 3
(defn f3 [coll]
  (let [v (into [] coll)
        len (count v)
        indices (take len (iterate inc 0))]
    (reduce
     (fn [check i]
       (and check
            (= (get v i)
               (get v (- len i 1)))))
     true
     indices)));; => #'user/f3
(false? (f3 '(1 2 3 4 5))) ;; => true
(true? (f3 "racecar")) ;; => true
(true? (f3 [:foo :bar :foo])) ;; => true
(true? (f3 '(1 1 3 3 1 1))) ;; => true
(false? (f3 '(:a :b :c))) ;; => true
