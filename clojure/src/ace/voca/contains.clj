(contains? [1 2 3] 2) ;; => true
(contains? #{1 2 3} 2) ;; => true
(contains? {1 :a 2 :b} 2) ;; => true
(contains? {1 :a 2 :b} :b) ;; => false
(contains? {:a 1} :a) ;; => true
(contains? {:a nil} :a) ;; => true
(contains? {:a 1} 1) ;; => false
(contains? [:a :b :c] :b) ;; => false
(contains? [:a :b :c] 2) ;; => true

;; Although lists are sequences, they are not keyed sequences.
;; contains? should not be used for lists.
;; (contains? '(1 2 3) 1)
;; IllegalArgumentException (Clojure >=1.5)

;; It also works on native arrays, HashMaps or HashSets:
;; Can be used to test set membership

(def s #{"a" "b" "c"})

;; The members of a set are the keys of those elements.

(contains? s "a") ;; => true
(contains? s "z") ;; => false

;; When "key" is a number, it is expected to be an integer.
;; Beyond that limit, lossy truncation may result in unexpected results:
(contains? [1 2 3] 4294967296)
;; => true

;; java method of contains

(.contains [:a :b :c] :c) ;; => true
(contains? (set [:a :b :c]) :b) ;; => true
(contains? #{:a :b} :a) ;; => true

(defn contains?' [[x & xs] elem]
  (if (= x elem)
    true
    (if xs
      (contains?' xs elem)
      false)))
(contains?' [:a :b] :a) ;; => true
(contains?' #{:a :b} :a) ;; => true
(contains?' #{:a :b} :c) ;; => false

(defn contains?-b [[x & xs] item]
  (cond (nil? x) false
        (= x item) true
        :else (contains?-b xs item)))
(contains?-b [:a :b] :a) ;; => true
(contains?-b #{:a :b} :a) ;; => true
(contains?-b #{:a :b} :c) ;; => false