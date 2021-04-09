(comment
  (defn complement
    "Takes a fn f and returns a fn that takes the same arguments as f,
  has the same effects, if any, and returns the opposite truth value."
    {:added "1.0"
     :static true}
    [f] 
    (fn 
      ([] (not (f)))
      ([x] (not (f x)))
      ([x y] (not (f x y)))
      ([x y & zs] (not (apply f x y zs))))))

((complement <) 3 2)
;; => true

(filter (complement odd?) [1 2 3 4])
;; => (2 4)

((complement even?) 1)
;; => true

(#(not (even? %)) 1)
;; => true
