;; future
;; Takes a body of expressions and yields a future object that will
;; invoke the body in another thread, and will cache the result and
;; return it on all subsequent calls to deref/@. If the computation has
;; not yet finished, calls to deref/@ will block, unless the variant of
;; deref with timeout is used. See also - realized?.
(def f
  (future (Thread/sleep 7000)
          (println "done")
          100))

(realized? f)
;; => false ;; before sleep is done
;; => true ;; after sleep is done

@f ;; => 100
(realized? f)
;; => true

(future (Thread/sleep 4000)
        (prn "I will print after 4 seconds."))
;; => #<Future@3f7ba8f6: :pending>

;;
(let [result
      (future (Thread/sleep 3000)
              (inc 1))]
  (deref result))
;; => 2 ;; returns after 3 seconds

;;
(let [result (future (Thread/sleep 3000)
                     (println "calculated at" (.getName (Thread/currentThread)))
                     ;; calculated at clojure-agent-send-off-pool-350
                     (* 10 10))]
  (println "received at" (.getName (Thread/currentThread)))
  ;; received at nREPL-session-95bb8b4b-5cc0-4121-b716-3afb2f518671
  @result)
