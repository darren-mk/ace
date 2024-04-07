(def a (ref 1))

a :=> "#<Ref@5e3da221: 1>"
(deref a) :=> 1
@a :=> 1

(alter a inc) :=> "error, should be in dosync"

(dosync (alter a inc)) :=> 2

(deref a) :=> 2
@a :=> 2

(ref-set a 100) :=> "error, should be in dosync"

(dosync (ref-set a 100))
(deref a) :=> 100
@a :=> 100

