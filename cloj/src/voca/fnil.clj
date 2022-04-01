((fnil inc 1000) 1)
;; => 2

((fnil inc 1000) nil)
;; => 1001

((fnil + 1) nil)
;; => 1

((fnil + 1) 1 2 3)
;; => 6


;;;; implementation

;; 1
(defn fnil-2 [f default]
  (fn [x & xs]
    (if (nil? x)
      (f default)
      (apply f (cons x xs)))))
((fnil-2 inc 1000) 1) ;; => 2
((fnil-2 inc 1000) nil) ;; => 1001
((fnil-2 + 1) 1 2 3 4) ;; => 10

;; 2
(defn fnil-b [f v]
  (fn [& x]
    (if (nil? (first x))
      (f v)
      (apply f x))))
((fnil-b inc 1000) 1) ;; => 2
((fnil-b inc 1000) nil) ;; => 1001
((fnil-b + 1) nil) ;; => 1
((fnil-b + 1) 1 2 3) ;; => 6


;; example problem

(def words
  (clojure.string/split
   "Some of these words are repeated. Some are not."
   #"\W"))
;; => #'user/words

words
;; => ["Some" "of" "these" "words" "are" "repeated" "" "Some" "are" "not"]

(reduce (fn [count word]
          (update count word (fnil inc 0)))
        {}
        words)
;; => {"Some" 2,
;;     "of" 1,
;;     "these" 1,
;;     "words" 1,
;;     "are" 2,
;;     "repeated" 1,
;;     "" 1,
;;     "not" 1}
