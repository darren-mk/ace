(defn f1 [x]
  (let [thr (.getName (Thread/currentThread))]
    (println "processing at" thr)
    (inc x)))

(map f1 [1 2 3])
;; => processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    (2 3 4)

(pmap f1 [1 2 3])
;; processing at clojure-agent-send-off-pool-37
;; processing at clojure-agent-send-off-pool-51
;; processing at clojure-agent-send-off-pool-52
;; => (2 3 4)

(defn f2 [x]
  (Thread/sleep 1000) x)

(time (doall (map f2 (range 5))))
"Elapsed time: 5020.999583 msecs"

(time (doall (pmap f2 (range 5))))
"Elapsed time: 1005.309208 msecs"

