(reduce + [])
;; => 0           

(reduce + [1])
;; => 1          

(reduce + [1 2])
;; => 3        

(reduce + [1 2 3])
;; => 6

(reduce + 1 [])
;; => 1        

(reduce + 1 [2 3])
;; => 6

(reduce - [1 2 3])
;; => -4

(reduce - 100 [1 2])
;; => 97

;; reduce implementation 1
(defn reduce-alt-1 [f start coll]
  (loop [v start
         coll coll]
    (if (empty? coll)
      v
      (recur (f v (first coll)) (rest coll)))))
;; => #'user/reduce-alt-1
(reduce-alt-1 + 1 [2 3])
;; => 6
(reduce-alt-1 * 10 [2 3])
;; => 60

;; reduce implementation 2
(defn reduce-alt-2 [f start coll]
  (if (empty? coll)
    start
    (recur f (f start (first coll)) (rest coll))))
;; => #'user/reduce-alt-2
(reduce-alt-2 + 0 [1 2 3])
;; => 6
(reduce-alt-2 - 10 [1 2 3])
;; => 4
(reduce-alt-2 * 0 [1 2 3])
;; => 0
(reduce-alt-2 (fn [a b]
                (clojure.string/join
                 "_" [a b]))
              "oh" ["what" "is" "that?"])
;; => "oh_what_is_that?"

;; interview question
(defn print-unique
  "Interview question to ADT/Discovery by Dylan.
  Recommended to use `reduce` despite other possibilities."
  [coll]
  (reduce 
   (fn [last-elem x] 
     (when (not= last-elem x)           
       (prn x)
       x))
   nil 
   coll))
;; => #'user/print-unique
(print-unique ["aaa" "aaa" "bbb"])
;; => "bbb"

;; c
(defn reduce-c [f b l]
  (if (empty? l)
    b
    (reduce-c f (f b (first l)) (rest l))))
;; => #'user/reduce-c
(reduce-c (fn [a b] (+ a b 100)) 0 [1 2 3])
;; => 306
