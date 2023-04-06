;; delay
;; Takes a body of expressions and yields a Delay object that will
;; invoke the body only the first time it is forced (with force or deref/@), and
;; will cache the result and return it on all subsequent force calls. 

(def my-delay
  (delay (println "did it")
         100))
;; => #'focl.core/my-delay

(realized? my-delay)
;; => false

my-delay
;; => #<Delay@9d42984: :not-delivered>

(realized? my-delay)
;; => false

(force my-delay)
;; => 100

(realized? my-delay)
;; => true

(def ddd
  (delay
    (Thread/sleep 3000)
    (prn "delay piece is running")
                (rand 100)))

@ddd
(force ddd)
(realized? ddd)

(def delayed-v
  (delay
    (let [cur-thread-name (.getName (Thread/currentThread))]
      (println "run now at " cur-thread-name)
      cur-thread-name)))

(let [cur-thread-name (.getName (Thread/currentThread))]
  (println "copied now at " cur-thread-name)
  (= cur-thread-name @delayed-v)) ;; true
