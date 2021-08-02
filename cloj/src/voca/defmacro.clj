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

