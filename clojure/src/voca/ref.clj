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

(def r1
  (ref 100))

(def r2
  (ref 200))

(dosync
 (alter r1 - 50)
 (alter r2 + 50))

@r1 ;; => 50
@r2 ;; => 250

(dosync
 (alter r1 - 50)
 (/ 1 0)
 (alter r2 + 50))
;; error after first proc

@r1 ;; => 50 (did not change)
@r2 ;; => 250 (did not change)
