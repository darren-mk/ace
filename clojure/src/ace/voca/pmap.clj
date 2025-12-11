(defn show-thread-and-inc [x]
  (let [thr (.getName (Thread/currentThread))]
    (println "processing at" thr)
    (inc x)))

(map show-thread-and-inc [1 2 3])
;; => processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    processing at nREPL-session-c2038fe5-51a9-4bfe-9979-1b8c8d1d9fe8
;;    (2 3 4)

(pmap show-thread-and-inc [1 2 3])
;; processing at clojure-agent-send-off-pool-37
;; processing at clojure-agent-send-off-pool-51
;; processing at clojure-agent-send-off-pool-52
;; => (2 3 4)

(defn sleep-and-pass [x]
  (Thread/sleep 1000) x)

(time (doall (map sleep-and-pass (range 5))))
"Elapsed time: 5020.999583 msecs"

(time (doall (pmap sleep-and-pass (range 5))))
"Elapsed time: 1005.309208 msecs"

(defn pmap'
  ([f col]
   (pmap' f col (map #(future (f %)) col)))
  ([_ _ futs]
   (seq (reduce (fn [a x] (conj a @x)) [] futs))))
(time (doall (pmap sleep-and-pass (range 5))))
"Elapsed time: 1005.280584 msecs"
(pmap' show-thread-and-inc [1 2 3]) ;; => (2 3 4)
