;; (reductions f coll)
;; (reductions f init coll)
;; Returns a lazy seq of the intermediate values
;; of the reduction (as per reduce) of coll by f,
;; starting with init.

(reductions + [1 2 3])
;; => (1 3 6)

(reductions inc [1 2 3])

(seq [1 2 3])
;; => (1 2 3)

(seq #{1 2 3})
;; => (1 3 2)


