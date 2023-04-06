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


(def chan-a (a/chan 10))

(def sum-a (atom 0))

(dotimes [_ 10]
  (a/go (loop []
          (let [n (a/<! chan-a)]
            (swap! sum-a + n))
          (recur))))

(a/go (doseq [x (range 100)]
        (a/>! chan-a x)))

@sum-a
;; => 4950

;; listner process
(def chat-chan (a/chan 1))
;;
(a/go (loop []
        (let [msg (a/<! chat-chan)]
          (if (= :stop msg)
            (println "loop is stopped.")
            (do (println "at" (.getName (Thread/currentThread))
                         "received:" msg)
                (recur))))))
;;
(println (.getName (Thread/currentThread)))
(a/go (a/>! chat-chan "yo!"))
(a/go (a/>! chat-chan 123))
(a/go (a/>! chat-chan [1 2 3]))
(a/go (a/>! chat-chan {:a 1 :b 2}))
(a/go (a/>! chat-chan "cool, bye"))
(a/go (a/>! chat-chan :stop))
