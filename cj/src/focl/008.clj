(ns focl.008)

;; Intro to Sets
;; Difficulty:	Elementary
;; Topics:	
;; Sets are collections of unique values.
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))

(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d))) ;; => true
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d})) ;; => true
