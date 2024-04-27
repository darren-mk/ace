;; clojure.core/some
;; ([pred coll])
;; Returns the first logical true value of (pred x) for any x in coll,
;; else nil.  One common idiom is to use a set as pred, for example
;; this will return :fred if :fred is in the sequence, otherwise nil:
;; (some #{:fred} coll)

(some even? [1 2 3 4 5 6])
;; => true
(some #(when (even? %) %) [1 2 3 4 5])
;; => 2
(some neg? [-1 2 5])
;; => true

;; implementation 1
(defn some-alt-1 [p coll]
  (->> (for [item coll]
         (p item))
       (reduce
        (fn [a b] (or a b))
        false)))
;; => #'user/some-alt-1
(some-alt-1 even? [1 2 3 4 5 6])
;; => true
(some-alt-1 neg? [1 2 5])
;; => false

;; implementation 2
(defn some-alt-2 [p coll]
  (->> (for [item coll]
         (p item))
       (reduce #(or %1 %2)
               false)))
;; => #'user/some-alt-2
(some-alt-2 even? [1 2 3 4 5 6])
;; => true
(some-alt-2 neg? [1 2 5])
;; => false
