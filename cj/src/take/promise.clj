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
