;; https://github.com/clojure/core.async/blob/master/examples/walkthrough.clj

(require '[clojure.core.async :as a])

(def c (a/chan))
;; => #'user/c

c
;; => #object[clojure.core.async.impl.channels.ManyToManyChannel 0x3d3073c8 "clojure.core.async.impl.channels.ManyToManyChannel@3d3073c8"]

(a/>!! c "hello")
(a/<!! c)

c

(a/close! c)
;; => nil

(let [c (a/chan)]
  (a/go 
    (a/>! c "hello")
    (prn (a/<! c)))
  (a/close! c))

(let [c (a/chan 1)]
  (a/>!! c "hello")
  (prn (a/<!! c))
  (a/close! c))

(let [c (a/chan 1)]
  (prn (a/<!! c))
  (a/>!! c "hello")
  (a/close! c)) ;; ???

(let [c (a/chan 10)]
  (a/>!! c "1")
  (a/>!! c "2")
  (a/>!! c "3")
  (prn (a/<!! c))
  (prn (a/<!! c))
  (prn (a/<!! c))
  (a/close! c))
