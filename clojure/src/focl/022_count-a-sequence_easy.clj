;; https://4clojure.oxal.org/#/problem/22

;; Problem 22
;; Write a function which returns the total number of elements in a sequence.
;; (= (__ '(1 2 3 3 1)) 5)
;; (= (__ "Hello World") 11)
;; (= (__ [[1 2] [3 4] [5 6]]) 3)
;; (= (__ '(13)) 1)
;; (= (__ '(:a :b :c)) 3)

;; 1
(defn f1 [coll]
  (loop [i 0
         coll coll]
    (if (empty? coll)
      i
      (recur (inc i)
             (rest coll)))))
(= (f1 '(1 2 3 3 1)) 5) ;; => true
(= (f1 "Hello World") 11) ;; => true
(= (f1 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f1 '(13)) 1) ;; => true
(= (f1 '(:a :b :c)) 3) ;; => true

;; 2
(defn f2 [coll]
  (apply max 
         (keys 
          (zipmap (iterate inc 1) coll))))
(= (f2 '(1 2 3 3 1)) 5) ;; => true
(= (f2 "Hello World") 11) ;; => true
(= (f2 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f2 '(13)) 1) ;; => true
(= (f2 '(:a :b :c)) 3) ;; => true

;; 3
(defn f3 [coll]
  (->> (zipmap (iterate inc 0) coll)
      keys
      (apply max)
      inc)) ;; => #'user/f3
(= (f3 '(1 2 3 3 1)) 5) ;; => true
(= (f3 "Hello World") 11) ;; => true
(= (f3 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f3 '(13)) 1) ;; => true
(= (f3 '(:a :b :c)) 3) ;; => true

;; 4
(defn f4 [coll]
  (reduce (fn [count elem]
            (if (nil? elem)
              count
              (inc count)))
          0 coll)) ;; => #'user/f4
(= (f4 '(1 2 3 3 1)) 5) ;; => true
(= (f4 "Hello World") 11) ;; => true
(= (f4 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f4 '(13)) 1) ;; => true
(= (f4 '(:a :b :c)) 3) ;; => true

(defn f5 [[x & xs]]
  (if x (+ 1 (f5 xs)) 0))
(= (f5 '(1 2 3 3 1)) 5) ;; => true
(= (f5 "Hello World") 11) ;; => true
(= (f5 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f5 '(13)) 1) ;; => true
(= (f5 '(:a :b :c)) 3) ;; => true

(defn f6
  ([col]
   (f6 col 0))
  ([[x & xs] len]
   (if x (recur xs (inc len))
       len)))
(= (f6 '(1 2 3 3 1)) 5) ;; => true
(= (f6 "Hello World") 11) ;; => true
(= (f6 [[1 2] [3 4] [5 6]]) 3) ;; => true
(= (f6 '(13)) 1) ;; => true
(= (f6 '(:a :b :c)) 3) ;; => true
