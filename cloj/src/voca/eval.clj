(def d (list + 1 2 3))
;; => #'user/d

(eval d)
;; => 6

(eval (concat d [4]))
;; => 10

(eval (list 'def 'd-2 (concat d [10])))
;; => #'user/d-2
;; d-2
;; => 16
