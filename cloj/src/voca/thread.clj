(ns voca.thread
  (:require [clojure.core.async :as a :refer
             [chan go thread <!! >!! <!
              close! timeout put!]]))

;;;; example thread transient
(defn example-thread-transient [ch]
  (thread
    (let [val-taken (<!! ch)]
      (prn "taken from channel: " val-taken)
      ;; thread is done, garbage-collected.
      )))
;; => #'user/example-thread-transient
(def c1 (chan))
;; => #'user/c
(example-thread-transient c1)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x7d8b75b9 "clojure.core.async.impl.channels.ManyToManyChannel@7d8b75b9"]
(>!! c1 "Hi, Darren.")
;; => true
;; "taken from channel: " "Hi, Darren."
;;;; alternatively, put! w works in the same way as >!!.
;;;; not sure what is supposed to be different?
(put! c1 "Hi, Darren by put!")
;; => true
;; "taken from channel: " "Hi, Darren by put!"


;;;; example thread transient with go
(defn example-thread-transient-w-go [ch]
  (go (prn "taken from channel: " (<! ch))))
;; => #'user/example-thread-transient-w-go
(def c2 (chan))
;; => #'user/c
(example-thread-transient-w-go c2)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x51c58915 "clojure.core.async.impl.channels.ManyToManyChannel@51c58915"]
(>!! c2 "Yes!")
;; => true 
;; "taken from channel: " "Yes!" 


;;;; example thread continuing 
(defn example-thread-continuing [ch]
  (thread
    (loop []
      (let [val-taken (<!! ch)]
        (when val-taken
          (prn "taken from channel: " val-taken)
          (recur))))
    ;; thread done, garbage collected.
    (prn "thread done.")))
;; => #'user/example-thread-continuing
(def c3 (chan))
;; => #'user/c
(example-thread-continuing c3)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]
(>!! c3 1)
;; => true
;; "taken from channel: " 1
(>!! c3 2)
;; nil 
;; "taken from channel: " 2
(>!! c3 3)
;; => true
;; "taken from channel: " 3
(>!! c3 4)
;; => true
;; "taken from channel: " 4
(>!! c3 5)
;; => true
;; "taken from channel: " 5
(close! c3)
;; => nil
;; "thread done."


;;;; example thread continuing with go
(defn example-thread-continuing-w-go [ch]
  (go
    (loop []
      (let [v (<! ch)] 
        (when v
          (prn "taken from channel: " v)
          (recur))))
    (prn "thread done.")))
;; => #'user/example-thread-continuing-w-go
(def c4 (chan))
;; => #'user/c                                        ;
(example-thread-continuing-w-go c4)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x42ea55fa "clojure.core.async.impl.channels.ManyToManyChannel@42ea55fa"]
(>!! c4 1)
;; => true
;; "taken from channel: " 1
(>!! c4 3)
;; => true
;; "taken from channel: " 3


;;;; example thread continuing slow 
(defn example-thread-continuing-slow [ch]
  (thread
    (loop []
      (let [val-taken (<!! ch)]
        (when val-taken
          (prn "taken from channel: " val-taken)
          (<!! (timeout 5000))
          (recur))))
    ;; thread done, garbage collected.
    (prn "thread done.")))
;; => #'user/example-thread-continuing
(def c5 (chan))
;; => #'user/c
(example-thread-continuing-slow c5)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]
(>!! c5 1)
;; => true
;; "taken from channel: " 1
(>!! c5 2)
;; nil 
;; "taken from channel: " 2
(>!! c5 3)
;; => true
;; "taken from channel: " 3
(>!! c5 4)
;; => true
;; "taken from channel: " 4
(>!! c5 5)
;; => true
;; "taken from channel: " 5
(close! c5)
;; => nil
;; "thread done."


;;;; example thread continuing calculating
(defn example-thread-continuing-calculating [ch]
  (thread
    (loop []
      (let [[v ch-resp :as vs-taken] (<!! ch)]
        (when (some? vs-taken)
          (prn "taken from channel: " v)
          (let [calc-result (inc v)]
            (put! ch-resp calc-result))
          (recur))))
    (prn "thread is done.")))
;; => #'user/example-thread-continuing-calculating
(def c6 (chan))
;; => #'user/c
(def c6-resp (chan))
;; => #'user/c-resp
(thread
  (prn "result is: " (<!! c6-resp)))
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x7d7cc837 "clojure.core.async.impl.channels.ManyToManyChannel@7d7cc837"]
(example-thread-continuing-calculating c6)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x117cfac6 "clojure.core.async.impl.channels.ManyToManyChannel@117cfac6"]
(put! c6 [7 c6-resp])
;; => true
;; "taken from channel: " 7
;; "result is: " 8
(close! c6)
;; => nil
;; "thread is done."

;; check threads
(def thread-a
  (Thread.
   (fn []
     (println "it is being called at" (.getName (Thread/currentThread))))))
;; it is being called at Thread-17
(do (println "it is calling at" (.getName (Thread/currentThread)))
    (.start thread-a))
 ;; it is calling at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8


;; as counterexample to go using 8 threads
(def thrds (atom #{}))
(doseq [n (range 100)]
  (a/thread
    (swap! thrds conj (.getName (Thread/currentThread)))
    (println n)))
@thrds
#{"async-thread-macro-8" "async-thread-macro-21"
  "async-thread-macro-9" "async-thread-macro-30"
  "async-thread-macro-17" "async-thread-macro-1"
  "async-thread-macro-24" "async-thread-macro-27"
  "async-thread-macro-6" "async-thread-macro-7"
  "async-thread-macro-13" "async-thread-macro-22"
  "async-thread-macro-18" "async-thread-macro-20"
  "async-thread-macro-29" "async-thread-macro-19"
  "async-thread-macro-2" "async-thread-macro-28"
  "async-thread-macro-14" "async-thread-macro-33"
  "async-thread-macro-10" "async-thread-macro-32"
  "async-thread-macro-12" "async-thread-macro-4"
  "async-thread-macro-26" "async-thread-macro-31"
  "async-thread-macro-15" "async-thread-macro-25"
  "async-thread-macro-11" "async-thread-macro-5"
  "async-thread-macro-16" "async-thread-macro-3"
  "async-thread-macro-23"}
(count @thrds)
33
