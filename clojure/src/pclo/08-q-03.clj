;; p. 194
;; implement bench

;; 1
(defmacro bench-01 [expr]
  `(let [start# (System/nanoTime)
         result# ~expr]
     {:result result#
      :elapsed (- (System/nanoTime) start#)}))
;; => #'user/bench-01
(bench-01 (+ 1 1))
;; => {:result 2, :elapsed 433716}
(macroexpand '(bench-01 (+ 1 1)))
;; => (let*
;;     [start__6346__auto__
;;      (java.lang.System/nanoTime)
;;      result__6347__auto__
;;      (+ 1 1)]
;;     {:result result__6347__auto__,
;;      :elapsed
;;      (clojure.core/- (java.lang.System/nanoTime) start__6346__auto__)})
