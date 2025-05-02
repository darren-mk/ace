;; Returns a lazy seq of the elements of coll separated by sep.
;; Returns a stateful transducer when no collection is provided.

(interpose ", " ["me" "you" "us"])
;; => ("me" ", " "you" ", " "us") 

(interpose 0 [1 2 3])
;; => (1 0 2 0 3)

(defn interpose' [x coll]
  (let [f (fn [a b] [a b])]
    (-> (map f coll (repeat x))
        flatten
        butlast)))

(interpose' 0 [1 2 3])
:=> '(1 0 2 0 3)

(defn interpose'' [x l]
  (let [f (fn [a b] [a b])]
    (-> (map f l (repeat x))
        flatten butlast lazy-seq)))
(interpose'' 0 [1 2 3])
:=> '(1 0 2 0 3)

(defn interpose-3
  ([c l]
   (interpose-3 [] c l))
  ([acc c [x & xs]]
   (if-not x (butlast acc)
           (interpose-3
            (concat acc [x c])
            c xs))))
(interpose-3 0 [1 2 3])
;; => (1 0 2 0 3)
