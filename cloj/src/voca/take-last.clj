;; take-last
;; clojure.core
;; Available since 1.1 (source)
;; (take-last n coll)
;; Returns a seq of the last n items in coll.  Depending on the type
;; of coll may be no better than linear time.  For vectors, see also subvec.

(take-last 2 [1 2 3 4])
;; (3 4)

(take-last 2 [4])
;; (4)

(take-last 2 [])
;; nil

(take-last 2 nil)
;; nil

(take-last 0 [1])
;; nil

(take-last 3 [1 2 3 4 5 6 7 8 9])
;; => (7 8 9)
