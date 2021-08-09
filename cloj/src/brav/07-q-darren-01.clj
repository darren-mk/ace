;; pass a print statement in string
;; and evaluate it

(def s (str '(println 123)))
;; => #'user/s

s
;; => "(println 123)"

(eval (read-string s))
;; => nil
;; 123
