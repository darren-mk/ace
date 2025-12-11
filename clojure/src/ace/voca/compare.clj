(compare 1 3)
;; => -1

(compare 3 1)
;; => 1

(compare 3 3)
;; => 0

(compare "abc" "def")
;; => -3

(compare "def" "abc")
;; => 3

(compare "abc" "abc")
;; => 0

(compare [1 2] [1 3])
;; => -1
