;; clojure.core/swap!
;; ([atom f] [atom f x] [atom f x y] [atom f x y & args])
;; Atomically swaps the value of atom to be:
;; (apply f current-value-of-atom args). Note that f may be called
;; multiple times, and thus should be free of side effects.  Returns
;; the value that was swapped in.

(def counter (atom 0))
;; => #'user/counter

@counter
;; => 0

(swap! counter inc)
;; => 1

@counter
;; => 1

(swap! counter + 3)
;; => 5

@counter
;; => 5

(swap! counter - 5)
;; => 0

@counter
;; => 0
