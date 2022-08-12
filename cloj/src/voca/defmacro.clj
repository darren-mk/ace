(defmacro infix [symbols]
  (list (second symbols)
        (first symbols)
        (last symbols)))

(infix (1 + 2))
;; => 3

(macroexpand '(infix (1 + 2)))
;; => (+ 1 2)

(defmacro when [test & body]
  (list 'if test (cons 'do body)))

(when (even? 2) (+ 1 2))
;; => 3

(macroexpand
 '(when (even? 2) (+ 1 2) (print "hi!")))
;; => (if (even? 2) (do (+ 1 2) (print "hi!")))


(defmacro require-not-nil!
  [& params]
  (let [checks
        (map
         (fn [p]
           `(when (nil? ~p)
              (throw
               (ex-info
                (str '~p " cannot be nil!")
                {:problem :cant-be-nil
                 :param '~p}))))
         params)]
    `(do ~@checks)))

(require-not-nil! :a nil "c")

;; https://www.braveclojure.com/read-and-eval/
(defmacro ignore-last-item [l]
  (butlast l))

(ignore-last-item (+ 1 2 3))
;; => 3
(macroexpand '(ignore-last-item (+ 1 2 3)))
;; => (+ 1 2)

(ignore-last-item (-> 3 inc dec))
;; => 4
(macroexpand '(ignore-last-item (-> 3 inc dec)))
;; => (inc 3)

;; https://www.braveclojure.com/read-and-eval/
(defmacro infix-three-items [infix]
  (let [a (first infix)
        b (second infix)
        c (last infix)]
    (list b a c)))

;;(infix-three-items (1 + 2))
;; => 3

;; Exercise 1.
;; Use the list function, quoting, and read-string to create a list that,
;; when evaluated, prints your first name and your favorite sci-fi movie.
(eval (read-string "(do (print \"\ndarren\") (print \"\nback to the future\"))"))
;; darren
;; back to the future


