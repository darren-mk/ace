;; clojure.core/swap!
;; ([atom f] [atom f x] [atom f x y] [atom f x y & args])
;; Atomically swaps the value of atom to be:
;; (apply f current-value-of-atom args). Note that f may be called
;; multiple times, and thus should be free of side effects.  Returns
;; the value that was swapped in.

(def counting (atom 0))
;; => #'user/counter

@counting
;; => 0

(swap! counting inc)
;; => 1

@counting
;; => 1

(swap! counting + 3)
;; => 5

@counting
;; => 5

(swap! counting - 5)
;; => 0

@counting
;; => 0
