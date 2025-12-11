(let [grade 85]
  (cond
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "B"

(defn cond' [& pvs]
  (if
   (= :else (first pvs)) (last pvs)
   (if (first pvs) (second pvs)
       (apply cond' (-> pvs rest rest)))))
(let [grade 65]
  (cond'
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
;; => "D"

(defn cond'' [& bvs]
  (let [b (first bvs)
        v (second bvs)]
    (if (or b (= :else b)) v
        (apply cond'' (-> bvs rest rest)))))
(cond'' false "A" false "B" :else "C")
;; => "C"
(cond'' false "A" true "B" :else "C")
;; => "B"

(defn cond''' [b v & r]
  (if (or (true? b) (= :else b)) v
      (apply cond''' r)))
(let [grade 65]
  (cond'''
    (>= grade 90) "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F")) ;; => "D"

(defn cond-d [b v & r]
  (if (or (true? b) (= :else b)) v
      (apply cond-d r)))
(let [grade 65]
  (cond-d
   (>= grade 90) "A"
   (>= grade 80) "B"
   (>= grade 70) "C"
   (>= grade 60) "D"
   :else "F")) ;; => "D"

(defn cond-e [b v & r]
  (if (or (true? b) (= :else b)) v
      (apply cond-e r)))
(let [grade 65]
  (cond-e
   (>= grade 90) "A"
   (>= grade 80) "B"
   (>= grade 70) "C"
   (>= grade 60) "D"
   :else "F"))

(defmacro adder [x y]
  (list '+ x y))

(macroexpand (adder 1 2))

(defmacro cond-q
  "Takes a set of test/expr pairs. It evaluates each test one at a
  time.  If a test returns logical true, cond evaluates and returns
  the value of the corresponding expr and doesn't evaluate any of the
  other tests or exprs. (cond) returns nil."
  {:added "1.0"}
  [& clauses]
  (when clauses
    (list 'if (first clauses)
          (if (next clauses)
            (second clauses)
            (throw (IllegalArgumentException.
                    "cond requires an even number of forms")))
          (cons `cond-q (next (next clauses))))))
(cond-q false 1 false 2 true 3)
;; => 3
(cond-q )

(macroexpand '(cond-q false 1 false 2 true 3))
;; => (if false 1 (user/cond-q false 2 true 3))

(defmacro cond-f
  [& clauses]
  (when clauses
    (list 'if (first clauses)
          (second clauses)
          (cons `cond-f (-> clauses next next)))))

(cond-f false 1 false 2 true 3)
;; => Syntax error (StackOverflowError) compiling if at (src/voca/cond.clj:92:1).
;;    null
(macroexpand '(cond-f false 1 false 2 true 3))
;; => (if false 1 (user/cond-f false 2 true 3))


(macroexpand-1 '(cond-f false 1 false 2 true 3))

(cond-f false 1 false 2 true 3)

(let [grade 65]
  (cond-f
    false "A"
    (>= grade 80) "B"
    (>= grade 70) "C"
    (>= grade 60) "D"
    :else "F"))
