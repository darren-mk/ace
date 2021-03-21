;; https://www.4clojure.com/problem/40



;; iterate
(take 5 (iterate identity 0)) ;; => (0 0 0 0 0)
(take 3 (iterate inc 1)) ;; => (1 2 3)

;; repeat
(repeat 5 :a) ;; => (:a :a :a :a :a)

;; butlast


;; trial 1
(defn f1 [piece coll]
  (butlast 
   (interleave
    coll
    (iterate identity piece))))

(= (f1 0 [1 2 3]) [1 0 2 0 3]) ;; => true
(= (apply str (f1 ", " ["one" "two" "three"])) "one, two, three") ;; => true
(= (f1 :z [:a :b :c :d]) [:a :z :b :z :c :z :d]) ;; => true
