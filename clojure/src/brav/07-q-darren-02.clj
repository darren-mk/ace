;; write a maro that runs a reversed s-expression

(defmacro backward-runner
  [l]
  (reverse l))
;; => #'user/backward-runner

(backward-runner (1 2 3 +))
;; => 6


(meta #'backward-runner)

(comment
  {:arglists ([l]),
   :line 3,
   :column 1,
   :file "/home/user/Documents/projects/darren/new-repos/ace/cloj/src/brav/07-q-darren-02.clj",
   :name backward-runner,
   :ns #namespace[user],
   :macro true ;; <-- is flagged
   })


;; usually function call is applicative order evaluation

(+ (+ 3 4) 5) ;; inner evaluated first


;; macro

(backward-runner (1 2 3 +)) ;; inner not evaluated at all

#_(1 2 3 +) ;; number not a function error, therefore observe list is not evaluated


#_(backward-runner (1 2 3)) ;; three not a function


#_(backward-runner '(1 2 3 +)) ;; Unable to resolve symbol: quote in this context, because its special form

(read-string "'(1 2 3 +)")
;; (quote (1 2 3 +))
