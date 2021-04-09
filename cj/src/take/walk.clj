(use 'clojure.walk)
;; => nil

(meta #'walk)
;; => {:arglists ([inner outer form]),
;;     :doc
;;     "Traverses form, an arbitrary data structure.  inner and outer are\n  functions.  Applies inner to each element of form, building up a\n  data structure of the same type, then applies outer to the result.\n  Recognizes all Clojure data structures. Consumes seqs as with doall.",
;;     :added "1.1",
;;     :line 35,
;;     :column 1,
;;     :file "clojure/walk.clj",
;;     :name walk,
;;     :ns #namespace[clojure.walk]}

(walk #(* 2 %) #(apply + %) [1 2 3 4 5])
;; => 30

(walk #(- % 1) #(apply + %) [1 2 3 4 5])
;; => 10
