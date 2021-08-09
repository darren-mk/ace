;; write a maro that runs a reversed s-expression

(defmacro backward-runner
  [l]
  (reverse l))
;; => #'user/backward-runner

(backward-runner (1 2 3 +))
;; => 6
