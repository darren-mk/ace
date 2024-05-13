;; write a macro that runs
;; elements in reversed order

(defmacro take-and-backward
  [& elem]
  (reverse elem))
;; => #'user/take-and-backward

(take-and-backward 1 2 3 +)
;; => 6
