;; https://github.com/clojure/core.async/blob/master/examples/walkthrough.clj

(require '[clojure.core.async :refer [chan close! >! <! go]])

(def c (chan))
;; => #'user/c

c
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0x3d3073c8 "clojure.core.async.impl.channels.ManyToManyChannel@3d3073c8"]

(>!! c "hello")
(<!! c)

c

(close! c)
;; => nil


(let [c (chan 10)]
  (go 
    (>! c "hello")
   ;; (>! c "darren")
    (prn (<! c)))
  (close! c))


(let [c (chan 10)]
  (>!! c "1")
  (>!! c "2")
  (>!! c "3")
  (prn (<!! c))
  (prn (<!! c))
  (prn (<!! c))
  (prn (<!! c))
  (close! c))

(prn (<!! c))
