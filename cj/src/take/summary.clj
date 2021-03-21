;; dotimes
(dotimes [x 3]
  (prn x)) ;; print 0 1 2

;; go
(require '[clojure.core.async :refer :all])
(do
  (go
    (dotimes )))

;; includes?
(clojure.string/includes? "abc" "b") ;; => true
(clojure.string/includes? "abc" "B") ;; => false

;; int
(int 3.2)

;; into
;; (into) (into to) (into to from) (into to xform from)
(into (sorted-map) [[:a 1] [:c 3] [:b 2]]) ;; => {:a 1, :b 2, :c 3}
(into [1 2 3] '(4 5 6)) ;; => [1 2 3 4 5 6]
(into {:x 4} [{:a 1} {:b 2} {:c 3}]) ;; => {:x 4, :a 1, :b 2, :c 3}

;; keys
(keys {:a 1 :b 2}) ;; => (:a :b)

;; lower-case
(clojure.string/lower-case "AB") ;; => "ab"

;; merge-with
;; (merge-with f & maps)
(merge-with + {:a 1 :b 2} {:a 9 :c 0}) ;; => {:a 10, :b 2, :c 0}
(merge-with cons {:a 1 :b 2} {:a 9 :c 0})

;; mod
(mod 10 7) ;; => 3

;; min
(min 3 4 5) ;; => 3
(min 3.12 4 5) ;; => 3.12

;; not-equal
(not= 2 3) ;; => true
(not= 3 3 3) ;; => false
(not= 3 3 4 4) ;; => true

;; parseint
(Integer/parseInt "123") ;; => 123

;; persistent!
(def t (transient {:a 1})) ;; => #'focl.core/t
(assoc! t :b 2) ;; -> shows message regarding type
(count t) ;; => 2
(persistent! t) ;; can be run only once
(comment (assoc1 t :c 3)) ;; gets error as persistent 

;; plus quote
(+' 1 2) ;; => 3
(apply +' (range 10000000000000
                 10000000001000))
;; => 10000000000499500

;; pmap
(pmap inc [1 2 3]) ;; => (2 3 4)
(time (pmap inc [1 2 3]))
;; => (2 3 4)
;; "Elapsed time: 0.872472 msecs"
(time (map inc [1 2 3]))
;; => (2 3 4)
;; "Elapsed time: 0.081481 msecs"

;; A function that simulates a long-running process by calling Thread/sleep:
(defn long-running-job [n]
    (Thread/sleep 3000) ; wait for 3 seconds
    (+ n 10))

;; Use `doall` to eagerly evaluate `map`, which evaluates lazily by default.

;; With `map`, the total elapsed time is just under 4 * 3 seconds:
(time (doall (map long-running-job (range 4))))
"Elapsed time: 11999.235098 msecs"
(10 11 12 13)

;; With `pmap`, the total elapsed time is just over 3 seconds:
(time (doall (pmap long-running-job (range 4))))
"Elapsed time: 3200.001117 msecs"
(10 11 12 13)

;; range
(range 3) ;; => (0 1 2)
(range 3 6) ;; => (3 4 5)
(range 3 12 3) ;; => (3 6 9)
(range 5 2 -1) ;; => (5 4 3)
(take 3 (range)) ;; => (0 1 2)

;; read-string
(type (read-string "+")) ;; => clojure.lang.Symbol
((eval (read-string "+")) 1 2 3) ;; => 6
(type (quote +)) ;; => clojure.lang.Symbol
((eval (quote +)) 1 2 3) ;; => 6

;; repeat
(repeat 3 "a") ;; => ("a" "a" "a")
(defn repeat-2 [n x]
  (take n (iterate identity x)))
(repeat-2 3 "a") ;; => ("a" "a" "a")

;; repeatedly
(take 3 (repeatedly (fn [] "a"))) ;; => ("a" "a" "a")

;; reset!
(def age (atom 10)) ;; => #'focl.core/age
(reset! age 13) ;; => 13
@age ;; => 13

;; select-keys 
(select-keys {:a 1 :b 2 :c 3} [:a :b]) ;; => {:a 1, :b 2}

;; set
(set [1 1 2 2]) ;; => #{1 2}

;; sorted-map
;; keys must be the same type, so ordered
(sorted-map 3 4 1 2) ;; => {1 2, 3 4}
(sorted-map :z 0, :a 28, :b 35) ;; => {:a 28, :b 35, :z 0}
(hash-map "b" 1 :a 2) ;; => {"b" 1, :a 2}
(sorted-map "c" 2 "b" 3) ;; => {"b" 3, "c" 2}
(sorted-map 3 "a" 1 :z) ;; => {1 :z, 3 "a"}

;; split
;; (split s re) (split s re limit)
(require '[clojure.string :refer [split]])
(split "Lisp is great!" #" ") ;; => ["Lisp" "is" "great!"]
(split "Lisp!" #"") ;; => ["L" "i" "s" "p" "!"]

;; swap!
(def age (atom 10)) ;; => #'focl.core/age
(swap! age inc) ;; => 12
(swap! age #(* 2 %)) ;; => 48

;; syntax quoting
;; use backtick
`(+ 1 2) ;; => (clojure.core/+ 1 2)
`(+ 1 (+ 1 1)) ;; => (clojure.core/+ 1 (clojure.core/+ 1 1))
`(+ 1 ~(+ 1 1)) ;; => (clojure.core/+ 1 2)

;; take
(take 2 [1 2 3 4]) ;; => (1 2)
(take 3 (repeat "a")) ;; => ("a" "a" "a")
(take 3 (iterate inc 6)) ;; => (6 7 8)

;; transient
(transient [1 2 3]) ;; -> shows message regarding type

;; true?
(true? [true false]) ;; => false
(true? [true true])

;; unquote
;; in syntax quoting
`(+ 1 2) ;; => (clojure.core/+ 1 2)
`(+ 1 (+ 1 1)) ;; => (clojure.core/+ 1 (clojure.core/+ 1 1))
`(+ 1 ~(+ 1 1)) ;; => (clojure.core/+ 1 2)

;; unquote
(def a 3) ;; => #'focl.core/a
'(a a) ;; => (a a)
`(a ~a) ;; => (a ~a)









(ns microservice)

(defn write-db!
  "This is an example of
  actual jobs that a microservice
  may do for the request.
  The job could be either
  reading, writing, or something else."
  []
  (prn "not written yet"))

(defn process-with-db!
  "This function represents the whole process
  wrapping up desired jobs under given contexts.
  Communications with other parts such as DB
  may fail or delay. And each case, it talks to
  circuit breaker and follows its order."
  []  
  (when (circut-breaker/allowed-to-access-db?)
    (try
      (write-db!)
      (/ 1 0) ;; testing purpose, to create error
      (circut-breaker/log-success)
      (catch Exception e
        (circut-breaker/log-failure)))))


(ns circut-breaker
  (:require [java-time :as t]))

;; constants 
(def threshold 5)
(def timeout (t/duration 3 :seconds))

;; states
;; For simplicity, each state value
;; is assigned to individual atom variable.
(def failures (atom 0))
(def state (atom :closed))
(def stamp (t/instant))

(defn allowed-to-access-db?
  "Predicate for the starting point
  of microservice process.
  Depending on the circuit breaker state,
  it would allow or not allow db-access.
  Also, it check the timeout value has been reached
  comparing the earlier timestamp and current timing. "
  []
  (when
      (and
       (= @state :open)
       (< timeout
          (time-between stamp (t/instant) :seconds)))
    (swap! state (fn [_] :half-open)))
  (case @state
    :closed true
    :open false
    :half-open true 
    true))

(defn log-failure
  "According to the diagram,
  when a process attempt fails,
  and if the number of accumulated
  failures exceeds the treshold,
  the state turns from closed to
  open directly (i.e. no half-open).
  And when fails, the stamp does not
  get updated because the system needs
  to monitor how long time has passed
  since the last success log."
  []
  (do 
    (swap! failures inc)
    (when (< threshold @failures)
      (do       
        (swap! state (fn [_] :open))))))
   
(defn log-success
  "According to the diagram,
  when a process is successful,
  it decreases the number of
  accunmulated failures.
  Also it updats the stamp to the
  current point in time
  as the system meausres how long time
  has passed since the last sucess log."
  []
  (do 
    (swap! failures dec)
    (when (< @failures threshold)
      (reset! stamp (t/instant))
      (swap! state (fn [_] :closed)))))

