(defn if-let-demo [arg]
  (if-let [_ arg]
    "then"
    "else"))
(if-let-demo 1) ;; => "then" 
(if-let-demo nil) ;; => "else"
(if-let-demo false) ;; => "else"
(if-let-demo true) ;; => "then"

(if-let [x nil]
  (+ x 10)
  "empty")
;; => "empty"

(if-let [x 1]
  (+ x 10)
  "empty")
;; => 11

(if-let [x (try
         (/ 1 0)
         (catch Exception e
           (do (prn e)
               {:a 1})))]
  (prn "x is " x)
  (prn "it is failed!"))
