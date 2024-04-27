;; promise

(def my-promise (promise))
;; => #'focl.core/my-promise

my-promise
;; "#promise[{:status :pending, :val nil} 0x2db0fbc8]"

(realized? my-promise)
;; => false

(deliver my-promise 3)
;; "#promise[{:status :ready, :val 3} 0x2db0fbc8]"

(realized? my-promise)
;; => true

my-promise
;; => #<Promise@2db0fbc8: 3>  

@my-promise
;; => 3


(def my-promise-2 (promise))
;; => #'focl.core/my-promise-2

my-promise-2
;; "#promise[{:status :pending, :val nil} 0x387af971]"

(realized? my-promise-2)
;; => false

(deliver my-promise-2 (fn [x y] (+ x y 1)))
;; "#promise[{:status :ready, :val #function[focl.core/eval5600/fn--5601]} 0x387af971]"

(realized? my-promise-2)
;; => true

my-promise-2
;; e: "#promise[{:status :ready, :val #function[focl.core/eval5600/fn--5601]} 0x387af971]"

(@my-promise-2 3 4)
;; => 8

(def mp-3 (promise))
;; => #'user/mp-3

(realized? mp-3)
;; => false

(deliver mp-3 (fn [x] (* x 100)))
;; => nil

(realized? mp-3)
;; => true

mp-3
;; => #<Promise@473330fb: #function[user/eval7539/fn--7540]>

(@mp-3 7)
;; => 700

(def heavy-answer (promise))
;; => #'user/heavy-answer

(doto (Thread. (fn []
                 (println "calculated at " (.getName (Thread/currentThread)))
                 (deliver heavy-answer 42)))
  .start)
;; => #object[java.lang.Thread 0x2cf51c35 "Thread[Thread-380,5,main]"]

(do (println "received at " (.getName (Thread/currentThread)))
    @heavy-answer)
;; => 42


(def promised-f (promise))

(def result (@promised-f 3)) ;; waiting

(deliver promised-f (fn [x] (* x 1000)))

result
;; => 3000
