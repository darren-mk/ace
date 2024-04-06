;; For a list or queue, same as first, for a vector, same as, but much
;; more efficient than, last. If the collection is empty, returns nil.

(peek (list 1 2 3))
:=> 1

(peek (vector 1 2 3))
:=> 3

(peek [1 2 3])
:=> 3

(last [1 2 3])
:=> 3

(time (peek (vec (range 500))))
"Elapsed time: 0.344209 msecs"
"Elapsed time: 0.128541 msecs"
"Elapsed time: 0.099792 msecs"
"Elapsed time: 0.333833 msecs"

(time (last (vec (range 500))))
"Elapsed time: 0.396458 msecs"
"Elapsed time: 0.3105 msecs"
"Elapsed time: 0.1945 msecs"
"Elapsed time: 0.307417 msecs"

