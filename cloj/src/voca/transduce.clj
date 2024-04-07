(transduce (map inc) conj (range 3))
:=> [1 2 3]

(transduce (map inc) + (range 3))
:=> 6

(transduce (filter odd?) conj (range 10))
:=> [1 3 5 7 9]

(transduce (filter odd?) * (range 10))
:=> 945
