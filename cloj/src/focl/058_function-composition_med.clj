;; https://4clojure.oxal.org/#/problem/58

;; Problem 58
;; Write a function which allows you to create function compositions.
;; The parameter list should take a variable number of functions,
;; and create a function applies them from right-to-left.
;; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
;; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
;; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
;; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
;; Special Restrictions : comp

;; 1
(defn f1 [& fs]
  (fn [& x] 
    (reduce
     (fn [result f]
       (f result))
     (if (= 1 (count x)) (first x) x)
     (reverse fs)))) ;; => #'user/f1
(= [3 2 1] ((f1 rest reverse) [1 2 3 4])) ;; => true
(= 5 ((f1 (partial + 3) second) [1 2 3 4])) ;; => true
(= true ((f1 zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((f1 #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
