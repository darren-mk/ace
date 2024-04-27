;; implement unless

;; 1
(defmacro unless-alt-1 [pred body]
  (list 'if (not pred) (do body)))
;; => #'user/unless-alt-1
(unless-alt-1 true "when true!")
;; => nil
(macroexpand '(unless-alt-1 true "when true!"))
;; => (if false "when true!")
(unless-alt-1 false "when false!")
;; => "when false!"
(macroexpand '(unless-alt-1 false "when false!"))
;; => (if true "when false!")

;; 2
(defmacro unless-alt-2 [pred body]
  (list 'if pred nil body))
;; => #'user/unless-alt-2
(unless-alt-2 true "when true!")
;; => nil
(macroexpand '(unless-alt-2 true "when true!"))
;; => (if true nil "when true!")
(unless-alt-2 false "when false!")
;; => "when false!"
(macroexpand '(unless-alt-2 false "when false!"))
;; => (if false nil "when false!")

;; 3
(defmacro unless-alt-3 [pred & bodies]
  (list 'if pred nil (cons 'do bodies)))
;; => #'user/unless-alt-3
(unless-alt-3 true
              (prn "when, ")
              (prn "true!"))
;; => nil
(macroexpand '(unless-alt-3 true
              (prn "when, ")
              (prn "true!")))
;; => (if true nil (do (prn "when, ") (prn "true!")))
(unless-alt-3 false
              (prn "when, ")
              (prn "true!"))
;; => nil
;; "when, "
;; "true!"
(macroexpand '(unless-alt-3 true
              (prn "when, ")
              (prn "true!")))
;; => (if true nil (do (prn "when, ") (prn "true!")))
