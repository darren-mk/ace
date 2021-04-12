(defn if-let-demo [arg]
  (if-let [_ arg]
    "then"
    "else"))
(if-let-demo 1) ;; => "then" 
(if-let-demo nil) ;; => "else"
(if-let-demo false) ;; => "else"
(if-let-demo true) ;; => "then"

(if-let [x nil]
  1 0)
;; => 0
