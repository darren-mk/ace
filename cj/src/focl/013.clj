(ns focl.013)

;; Sequences: rest
;; Difficulty:	Elementary
;; Topics:	
;; The rest function will return all the items of a sequence except the first.
;; (= __ (rest [10 20 30 40]))

(= [20 30 40] (rest [10 20 30 40])) ;; => true
