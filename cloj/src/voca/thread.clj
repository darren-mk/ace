(require '[clojure.core.async :refer
           [chan go thread <!! >!! <! >!
            close! timeout put! alts!]]
         '[clojure.tools.namespace.repl :refer
           [refresh]])


;;;; example thread transient
(defn example-thread-transient [ch]
  (thread
    (let [val-taken (<!! ch)]
      (prn "taken from channel: " val-taken)
      ;; thread done, garbage-collected.
      )))
;; => #'user/example-thread-transient
(def c (chan))
;; => #'user/c
(example-thread-transient c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x7d8b75b9 "clojure.core.async.impl.channels.ManyToManyChannel@7d8b75b9"]
(>!! c "Hi, Darren.")
;; => true
;; "taken from channel: " "Hi, Darren."
;;;; alternatively, put! w works in the same way as >!!.
;;;; not sure what is supposed to be different?
(put! c "Hi, Darren by put!")
;; => true
;; "taken from channel: " "Hi, Darren by put!"


;;;; example thread transient with go
(defn example-thread-transient-w-go [ch]
  (go (prn "taken from channel: " (<! ch))))
;; => #'user/example-thread-transient-w-go
(def c (chan))
;; => #'user/c
(example-thread-transient-w-go c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x51c58915 "clojure.core.async.impl.channels.ManyToManyChannel@51c58915"]
(>!! c "Yes!")
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
(def c (chan))
;; => #'user/c
(example-thread-continuing c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]
(>!! c 1)
;; => true
;; "taken from channel: " 1
(>!! c 2)
;; nil 
;; "taken from channel: " 2
(>!! c 3)
;; => true
;; "taken from channel: " 3
(>!! c 4)
;; => true
;; "taken from channel: " 4
(>!! c 5)
;; => true
;; "taken from channel: " 5
(close! c)
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
(def c (chan))
;; => #'user/c                                        ;
(example-thread-continuing-w-go c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x42ea55fa "clojure.core.async.impl.channels.ManyToManyChannel@42ea55fa"]
(>!! c 1)
;; => true
;; "taken from channel: " 1
(>!! c 3)
;; => true
;; "taken from channel: " 3


;;;; example thread continuing slow 
(defn example-thread-continuing-slow [ch]
  (thread
    (loop []
      (let [val-taken (<!! ch)]
        (when val-taken
          (do (prn "taken from channel: " val-taken)
              (<!! (timeout 5000))
              (recur)))))
    ;; thread done, garbage collected.
    (prn "thread done.")))
;; => #'user/example-thread-continuing
(def c (chan))
;; => #'user/c
(example-thread-continuing-slow c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]
(>!! c 1)
;; => true
;; "taken from channel: " 1
(>!! c 2)
;; nil 
;; "taken from channel: " 2
(>!! c 3)
;; => true
;; "taken from channel: " 3
(>!! c 4)
;; => true
;; "taken from channel: " 4
(>!! c 5)
;; => true
;; "taken from channel: " 5
(close! c)
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
(def c (chan))
;; => #'user/c
(def ch-resp (chan))
;; => #'user/c-resp
(thread
  (prn "result is: " (<!! ch-resp)))
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x7d7cc837 "clojure.core.async.impl.channels.ManyToManyChannel@7d7cc837"]
(example-thread-continuing-calculating c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel
;; 0x117cfac6 "clojure.core.async.impl.channels.ManyToManyChannel@117cfac6"]
(put! c [7 ch-resp])
;; => true
;; "taken from channel: " 7
;; "result is: " 8
(close! c)
;; => nil
;; "thread is done."


(doc alts!)



;;;; EX2
(defn ex2 [ch]
  (thread
    (loop []
      (let )

      ))

  
  )

(def cm (chan))
(def cr (chan))






(def echo-chan (chan))

(go (prn (<! echo-chan)))

(>!! echo-chan "ketchup")
