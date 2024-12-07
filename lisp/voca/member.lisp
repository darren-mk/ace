(member 1 '(1 2 3))
;; (1 2 3)

(member 4 '(1 2 3))
;; NIL

(member 1 '(1 2 3) :test #'=)
;; (1 2 3)

(member 1 '(1 2 3) :test #'equal)
;; (1 2 3)

(member "abc" '("abc" "def") :test #'equal)
;; ("abc" "def")
