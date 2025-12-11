;; implement when using macro

;; 1
(defmacro when-alt-1 [pred body]
  (list 'if pred (do body)))
;; => #'user/when-alt-1
(when-alt-1 true "yes!")
;; => "yes!"
(macroexpand '(when-alt-1 true "yes!"))
;; => (if true "yes!")
(when-alt-1 false "no!")
;; => nil
(macroexpand '(when-alt-1 false "no!"))
;; => (if false "no!")

;; 2
(defmacro when-alt-2 [pred body]
  (list 'if pred body nil))
;; => #'user/when-alt-1
(when-alt-2 true "yes!")
;; => "yes!"
(macroexpand '(when-alt-2 true "yes!"))
;; => (if true "yes!" nil)
(when-alt-2 false "no!")
;; => nil
(macroexpand '(when-alt-2 false "no!"))
;; => (if false "no!" nil)

;; 3
(defmacro when-alt-3 [pred & bodies]
  (list 'if pred (cons 'do bodies)))
(when-alt-3 true
  (prn "it is when, ")
  (prn "true!"))
;; => nil
;; "it is when, "
;; "true!"
(macroexpand '(when-alt-3 true
  (prn "it is when, ")
  (prn "true!")))
;; => (if true (do (prn "it is when, ") (prn "true!")))
(when-alt-3 false
  (prn "it is when, ")
  (prn "true!"))
;; => nil
(macroexpand '(when-alt-3 false
  (prn "it is when, ")
  (prn "true!")))
;; => (if false (do (prn "it is when, ") (prn "true!")))

;; 4
(defmacro when-alt-4 [pred & bodies]
  `(if ~pred ~(cons 'do bodies)))
;; => #'user/when-alt-4
(when-alt-4 true
  (prn "it is when, ")
  (prn "true!"))
;; => nil
;; "it is when, "
;; "true!"
(macroexpand '(when-alt-4 true
  (prn "it is when, ")
  (prn "true!")))
;; => (if true (do (prn "it is when, ") (prn "true!")))

;; 5
(defmacro when-alt-5 [pred & bodies]
  `(if ~pred (do ~@bodies)))
;; => #'user/when-alt-5
(when-alt-5 true
  (prn "it is when, ")
  (prn "true!"))
;; => nil
;; "it is when, "
;; "true!"
(macroexpand '(when-alt-5 true
  (prn "it is when, ")
  (prn "true!")))
;; => (if true (do (prn "it is when, ") (prn "true!")))
