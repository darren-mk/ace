(def h (transient {:x 1 :y 2 :z 3})) ;; => #'focl.core/h
(dissoc! h :z) ;; -> shows message regarding type
(count h) ;; => 2
