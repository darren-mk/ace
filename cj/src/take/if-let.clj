;; if-let
(defn if-let-demo [arg]
  (if-let [_ arg]
    "then"
    "else"))
(if-let-demo 1) ;; => "then" 
(if-let-demo nil) ;; => "else"
(if-let-demo false) ;; => "else"
(if-let-demo true) ;; => "then"
