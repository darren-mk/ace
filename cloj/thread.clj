(require '[clojure.core.async :refer
           [chan thread <!! >!! close! timeout]])

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
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0x7d8b75b9 "clojure.core.async.impl.channels.ManyToManyChannel@7d8b75b9"]

(>!! c "Hi, Darren.")
;; => true
;; "taken from channel: " "Hi, Darren."

(defn example-thread-continuing [ch]
  (thread
    (loop []
      (let [val-taken (<!! ch)]
        (when val-taken
          (do (prn "taken from channel: " val-taken)
              (recur)))))
    ;; thread done, garbage collected.
    (prn "thread done.")))
;; => #'user/example-thread-continuing

(def c (chan))
;; => #'user/c

(example-thread-continuing c)
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]

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
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0x10df7b10 "clojure.core.async.impl.channels.ManyToManyChannel@10df7b10"]

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



