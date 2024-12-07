;; does ref always need dosync for alteration?
;; then what about atom?

(def r (ref 1))
;; => #'user/r

(alter r inc)
;; error, no transaction running

(dosync (prn r)
        (alter r inc)
        (prn r))
;; => nil
;; #ref[{:status :ready, :val 1} 0x41e894d2]
;; #ref[{:status :ready, :val 2} 0x41e894d2]

@r
;; => 2

(def a (atom 1))
;; => #'user/a

(swap! a inc)
;; => 2

@a
;; => 2

(dosync (prn a)
        (swap! a inc)
        (prn a))
;; => nil
;; #atom[2 0x217f9792]
;; #atom[3 0x217f9792]

@a
;; => 3


;; observation:
;; alteration of ref should take place in dosync.
;; alteration of atom can but doesn't need to take place in dosync.
